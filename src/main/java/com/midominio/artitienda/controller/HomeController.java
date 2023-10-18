package com.midominio.artitienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String homeHandler(Model model){
		model.addAttribute("titulo", "Inicio");
		model.addAttribute("tituloH1", "Página Inicio");
		model.addAttribute("parrafo", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Praesent pretium fringilla neque, nec egestas justo tristique ut. Mauris lorem nulla, "
				+ "bibendum vestibulum egestas pharetra, ultricies non ipsum. Vestibulum suscipit purus egestas arcu scelerisque, "
				+ "in volutpat augue auctor. Morbi eu placerat purus, vitae suscipit lacus. Integer quis elit erat. Fusce non. ");
		return "home";
	}
		
}
