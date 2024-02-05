package es.dsw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {
	@GetMapping(value= {"/","/index"})
	public String index(Model model,
			@RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "password", required = false) String password){
		
		
        return "index";  
	}
	
	

}
