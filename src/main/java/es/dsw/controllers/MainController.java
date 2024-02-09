package es.dsw.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import es.dsw.connections.MySqlConnection;
import es.dsw.models.Producto;

@Controller
public class MainController {
	 @Autowired
	    private MySqlConnection mySqlConnection;


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
	
	@GetMapping(value= {"/registro"})
	public String registro(){
		
		
        return "registro";  
	}
	
	@GetMapping(value= {"/productos"})
	public String productos(Model model){
	        List<Producto> productos = new ArrayList<>(); 
	        String sql = "SELECT * FROM productos";

	        mySqlConnection.open();
	        ResultSet resultSet = mySqlConnection.executeSelect(sql);
	        try {
	            while (resultSet.next()) {
	                Producto producto = new Producto();
	                producto.setId_producto(resultSet.getInt("id_producto"));
	                producto.setNombre(resultSet.getString("nombre"));
	                producto.setDescripcion(resultSet.getString("descripcion"));
	                producto.setPrecio(resultSet.getFloat("precio"));
	                productos.add(producto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            mySqlConnection.close();
	        }


	        model.addAttribute("productos", productos);

		
        return "productos";  
	}
	
	
	@GetMapping(value= {"/contacto"})
	public String contacto(){
		
		
        return "contacto";  
	}
	@GetMapping(value= {"/carrito"})
	public String carrito(){
		
		
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

}
