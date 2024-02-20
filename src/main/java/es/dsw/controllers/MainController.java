package es.dsw.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.dsw.models.Carrito;
import es.dsw.models.Producto;
import es.dsw.models.User;
import es.dsw.repository.ProductoRepository;
import es.dsw.repository.UserRepository;


@Controller
@SessionAttributes({"carritos"})
public class MainController {



	@GetMapping(value= {"/","/index"})
	public String index(Model model,
			@RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "password", required = false) String password){
		
		
        return "index";  
	}
	
	@GetMapping(value= {"/login"})
	public String lgoin(){
		
		
        return "login";  
	}
	
	
	@Autowired
	private UserRepository userRepository;

	
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
	                       @RequestParam(name ="contraseña",defaultValue ="prueba") String contraseña) {
	    User user = new User();
	    user.setNombre(nombre);
	    user.setApellido1(apellido1);
	    user.setApellido2(apellido2);
	    user.setNif(nif);
	    user.setEmail(email);
	    user.setUsername(usuario);
	    user.setPassword(contraseña);
	    
	    userRepository.save(user);
	    
	    return "redirect:/login"; // Redirige a la página de inicio de sesión después del registro
	}
	
	@Autowired
    private ProductoRepository productoRepository;

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
    public Carrito modificarCarrito(@ModelAttribute("carritos") Map<Integer, Carrito> carritos,
                                     @RequestBody Carrito carrito) throws SQLException {

        if (carritos.containsKey(carrito.getId_producto())) {
            Carrito c = carritos.get(carrito.getId_producto());
            c.setCantidad_producto(c.getCantidad_producto() + 1);
        } else {
            Carrito c = new Carrito();
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
	public String carrito(Model model,@ModelAttribute("carritos") Map<Integer, Carrito> carritos){
		
		 
		
		// Calcula el total del precio de la compra
	        float total = 0.0f;
	        for (Carrito c : carritos.values()) {
	            total += c.getPrecio() * c.getCantidad_producto();
	        }

	        // Agrega el total al modelo
	        model.addAttribute("total", total);

		 
		
        return "carrito";  
	}
	
	@GetMapping(value= {"/formulario"})
	public String formulario(){
		
		
        return "formulario";  
	}
	@GetMapping(value= {"/pago"})
	public String pago(){
		
		
        return "pago";  
	}
	@GetMapping(value= {"/finalizar"})
	public String finalizar(){
		
		
        return "finalizar";  
	}
	
	@GetMapping(value= {"/BackOffice"})
	public String BackOffice(){
		
		
        return "BackOffice";  
	}

}
