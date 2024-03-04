package es.dsw.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.dsw.auxmodels.CarritoAux;
import es.dsw.auxmodels.Useraux;
import es.dsw.models.BakerDetails;
import es.dsw.models.Carrito;
import es.dsw.models.Pago;
import es.dsw.models.Pedido;
import es.dsw.models.Producto;
import es.dsw.models.Roles;
import es.dsw.models.User;
import es.dsw.models.UserRolPK;
import es.dsw.models.Userrol;
import es.dsw.repository.BakerDetailsRepository;
import es.dsw.repository.CarritoRepository;
import es.dsw.repository.PagoRepository;
import es.dsw.repository.PedidoRepository;
import es.dsw.repository.ProductoRepository;
import es.dsw.repository.RolRepository;
import es.dsw.repository.UserRepository;
import es.dsw.repository.Userrolrepository;


@Controller
@SessionAttributes({"carritos"})
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CarritoRepository carritoRepository;
	@Autowired
    private ProductoRepository productoRepository;
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagoRepository pagoRepository;
	@Autowired
	private BakerDetailsRepository bakerdetailsRepository;
	@Autowired
	private Userrolrepository userrolrepository;


	@GetMapping(value= {"/","/index"})
	public String index(Model model){
		
		
        return "index";  
	}
	
	@GetMapping(value= {"/login"})
	public String lgoin(){
		
		
        return "login";  
	}
	
	

	
    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro"; // Devuelve el nombre de la plantilla para el formulario de registro
    }


	@PostMapping("/registro")
	public String registro(@RequestParam(name ="nombre",defaultValue ="prueba") String nombre,
	                       @RequestParam(name ="apellido1",defaultValue ="prueba") String apellido1,
	                       @RequestParam(name ="apellido2",defaultValue ="prueba") String apellido2,
	                       @RequestParam(name ="nif",defaultValue ="prueba") String nif,
	                       @RequestParam(name ="email",defaultValue ="prueba") String email,
	                       @RequestParam(name ="usuario",defaultValue ="prueba") String usuario,
	                       @RequestParam(name ="contraseña",defaultValue ="prueba") String contraseña)
	{
	    User user = new User();
	 // Codificar la contraseña antes de devolver el objeto UserDetails
	    String encodedPassword = passwordEncoder.encode(contraseña);        
	    user.setNombre(nombre);
	    user.setApellido1(apellido1);
	    user.setApellido2(apellido2);
	    user.setNif(nif);
	    user.setEmail(email);
	    user.setUsername(usuario);
	    user.setPassword(encodedPassword);
	    
	    userRepository.save(user);
	    Roles rol=null;
	    Optional<Roles> r=rolRepository.findById(2);
	    if (r.isPresent()) {
	        rol=r.get(); 
	    } else {
	        // Handle the case where the "cliente" role is not found.
	        // You could throw an exception, log an error, or create a default role.
	        throw new RuntimeException("Cliente role not found!"); 
	    }
	    UserRolPK userRolPK = new UserRolPK(user.getUserID(), 2);
	    Userrol ur=new Userrol(user,rol);
	    ur.setId(userRolPK); 

	    userrolrepository.save(ur);
	    
	    
	    return "redirect:/login"; // Redirige a la página de inicio de sesión después del registro
	    
	}
	
	
	
    @GetMapping(value = {"/productos"})
    public String productos(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "productos";
    }
    
	@ModelAttribute("carritos")
    public Map<Integer, Carrito> getCarritos() {
        return new HashMap<>();
    }



	 @PostMapping(value = {"/modificar_carrito"}, produces = "application/json")
	    @ResponseBody
	    public CarritoAux modificarCarrito(@ModelAttribute("carritos") Map<Integer, CarritoAux> carritos,
	                                     @RequestBody CarritoAux carrito) throws SQLException {

	        if (carritos.containsKey(carrito.getId_producto())) {
	            CarritoAux c = carritos.get(carrito.getId_producto());
	            c.setCantidad_producto(c.getCantidad_producto() + 1);
	        } else {
	            CarritoAux c = new CarritoAux();
	            c.setId_producto(carrito.getId_producto());
	            c.setCantidad_producto(1);
	            c.setNombre(carrito.getNombre());
	            c.setPrecio(carrito.getPrecio());
	            carritos.put(carrito.getId_producto(), c);
	        }
	        

	        return carrito;
	    }
		
	
	@GetMapping(value= {"/contacto"})
	public String contacto(){
		
		
        return "contacto";  
	}
	
	
	@GetMapping(value= {"/carrito"})
	public String carrito(Model model,@ModelAttribute("carritos") Map<Integer, CarritoAux> carritos){
		
		 
		
		// Calcula el total del precio de la compra
	        float total = 0.0f;
	        for (CarritoAux c : carritos.values()) {
	            total += c.getPrecio() * c.getCantidad_producto();
	        }

	        // Agrega el total al modelo
	        model.addAttribute("total", total);

		 
		
        return "carrito";  
	}
	

	@GetMapping(value= {"/pago"})
	public String pago(@ModelAttribute("carritos") Map<Integer, CarritoAux> carritos){
		
		 if (carritos.isEmpty()) {
		        // Redirigir al usuario a la página de confirmación del carrito
		        return "redirect:/productos";
		    }
		
        return "pago";  
	}
	@GetMapping(value= {"/finalizar"})
	public String finalizar(){
		
		
        return "finalizar";  
	}
	

	@GetMapping(value= {"/BackOffice"})
	public String BackOffice(Model model,Authentication authentication){
		 List<Roles> roles = rolRepository.findAll();
	      model.addAttribute("roles", roles);
	      
	      if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
	            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	            String username = userDetails.getUsername();
	            User user = userRepository.findByUsername(username);
	            if (user != null) {
	                model.addAttribute("user", user);
	            }
	            
	         // Cargar la lista de pedidos
	            List<Pedido> pedidos = pedidoRepository.findAll();
	            model.addAttribute("pedidos", pedidos);
	            
	         // Cargar la lista de usuarios
	            List<User> usuarios = userRepository.findAll();
	            model.addAttribute("usuarios", usuarios );

	      }

        return "BackOffice";  
	}
	 @PostMapping(value = {"/CrearUsuario"}, produces = "application/json")
	 	@ResponseBody
	 public Useraux CrearUsuario(@RequestBody Useraux usuario) {
		
		    User user = new User();
		 // Codificar la contraseña antes de devolver el objeto UserDetails
		    String encodedPassword = passwordEncoder.encode(usuario.getPassword());        
		    user.setNombre(usuario.getNombre());
		    user.setApellido1(usuario.getApellido1());
		    user.setApellido2(usuario.getApellido2());
		    user.setNif(usuario.getNif());
		    user.setEmail(usuario.getEmail());
		    user.setUsername(usuario.getUsuario());
		    user.setPassword(encodedPassword);
		    
		    userRepository.save(user);
		    Roles rol=null;
			@SuppressWarnings("null")
			Optional<Roles> r=rolRepository.findById(usuario.getRol());
		    if (r.isPresent()) {
		        rol=r.get(); 
		    } else {
		        throw new RuntimeException("Cliente role not found!"); 
		    }
		    UserRolPK userRolPK = new UserRolPK(user.getUserID(), rol.getId());
		    Userrol ur=new Userrol(user,rol);
		    ur.setId(userRolPK); 

		    userrolrepository.save(ur);
		    
		    if(usuario.getRol()==3) {
		    	BakerDetails pastelero=new BakerDetails();
		    	 pastelero.setUserId(user.getUserID());
		    	 pastelero.setExperiencia(usuario.getExperiencia());
		    	 pastelero.setEspecialidad(usuario.getEspecialidad());
		    	 bakerdetailsRepository.save(pastelero);	
		    }
		 
		 
		 return usuario;
	 }
	
    @PostMapping({"/borrarUsuario"})
    public String borrarUsuario(@RequestParam("userId") @NonNull Integer userId) {
        try {
            userRepository.deleteById(userId);
            return "redirect:/BackOffice";
        } catch (Exception e) {
            return "Error al borrar el usuario: " + e.getMessage();
        }
    }
    
	   @PostMapping({"/aceptarPedido"})
	    public String aceptarPedido(Model model,@RequestParam("idPedido") @NonNull Integer idPedido) {
	        // Obtener el usuario autenticado
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String username = authentication.getName();
	        
	        // Buscar el usuario en la base de datos
	        User pastelero = userRepository.findByUsername(username);
	        
	        // Verificar si el usuario autenticado es un pastelero
	        if (pastelero != null && pastelero.getRoles().stream().anyMatch(r -> r.getRoleCode().equals("pastelero"))) {
	            // Buscar el pedido en la base de datos
	            Optional<Pedido> optionalPedido = pedidoRepository.findById(idPedido);
	            if (optionalPedido.isPresent()) {
	                Pedido pedido = optionalPedido.get();
	                // Actualizar el estado del pedido
	                pedido.setEstado("En proceso");
	                // Asignar el pastelero al pedido
	                pedido.setPastelero(pastelero);
	                // Guardar el pedido actualizado en la base de datos
	                pedidoRepository.save(pedido);
	                // Agregar mensaje de éxito a la plantilla
	                model.addAttribute("mensaje", "Pedido aceptado correctamente.");

	                return "redirect:/BackOffice"; // Redirigir al backoffice
	            } else {
	                model.addAttribute("error", "El pedido no se encontró.");
	                return "error"; // Página de error
	            }
	        } else {
	            model.addAttribute("error", "El usuario autenticado no es un pastelero.");
	            return "error"; // Página de error
	        }
	    }
	   @PostMapping({"/borrarPedido"})
	   public String borrarPedido(@RequestParam("idPedido") @NonNull Integer idPedido) {
	       try {
	           // Buscar el pedido por su ID
	           Optional<Pedido> optionalPedido = pedidoRepository.findById(idPedido);
	           
	           if (optionalPedido.isPresent()) {
	          
	               pedidoRepository.deleteById(idPedido);
	               
	               // Redirigir a la página de BackOffice en caso de éxito
	               return "redirect:/BackOffice";
	           } else {
	               // Manejar el caso en el que el pedido no existe
	               return "Error: No se encontró el pedido con ID " + idPedido;
	           }
	       } catch (Exception e) {
	           // Manejar cualquier excepción que pueda ocurrir durante la eliminación
	           return "Error al borrar el pedido: " + e.getMessage();
	       }
	   }


	   
	
	
	@PostMapping(value= {"/resumen"})
	public String resumen(Model model, @SessionAttribute("carritos") Map<Integer, CarritoAux> carritos,
			@RequestParam(name ="card-number",defaultValue ="prueba") String cardnumber,
			@RequestParam(name ="expiry",defaultValue ="prueba") String expiry,
			@RequestParam(name ="cvv",defaultValue ="prueba") String cvv) {
		
	    // Obtener el usuario autenticado
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    // Buscar el usuario en la base de datos por su nombre de usuario
	    User cliente = userRepository.findByUsername(username);

	    if (cliente != null ) {
	    	model.addAttribute("nombreUsuario", cliente.getNombre());
	        model.addAttribute("nifUsuario", cliente.getNif());
	        model.addAttribute("emailUsuario", cliente.getEmail());
	        
	        Pedido pedido = new Pedido();
	        pedido.setCliente(cliente);
	        pedidoRepository.save(pedido);
	        
	        Pago pago = new Pago();
	        pago.setUsuario(cliente); 
	        pago.setPedido(pedido); 
	        pago.setNombre(cliente.getNombre());
	        pago.setNumeroTarjeta(cardnumber);
	        pago.setCvv(cvv);
	        pago.setExpirationDate(expiry);
	        pagoRepository.save(pago);
	        
	        for (CarritoAux carrito : carritos.values()) {
	            Carrito nuevoCarrito = new Carrito();
	            nuevoCarrito.setPedido(pedido); 
	            nuevoCarrito.setCantidadProducto(carrito.getCantidad_producto());
	            Producto producto = productoRepository.findById(carrito.getId_producto()).orElse(null);
	            nuevoCarrito.setProducto(producto);
	            carritoRepository.save(nuevoCarrito); 
	        }
	        
	        return "resumen";
	    } else {
	        return "redirect:/productos"; 
	    }
	}

}
