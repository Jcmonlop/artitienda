package com.midominio.artitienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.midominio.artitienda.entity.Articulo;
import com.midominio.artitienda.service.ArticuloService;

@Controller
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;
	@Autowired
	private RestTemplate restTemplate;
	
	@ModelAttribute("titulo")
	private String dameTitulo() {
		return "Artículos";
	}
	
	@GetMapping("/articulo/todos")
	public String listarTodosLosArticulos(Model model) {
		//model.addAttribute("titulo", "Tiendas");
		model.addAttribute("tituloH1", "Listado de artículos");
		model.addAttribute("cantidad", articuloService.count());
		model.addAttribute("articulos", articuloService.todosLosArticulos());
		return "articulo/lista-articulos";
	}
	
	@GetMapping("articulo/borrar/{id}")
	public String borrarArticuloPorId(@PathVariable Long id, Model model) {
		articuloService.deleteById(id);
		return "redirect:/articulo/todos";
	}
	
	@GetMapping("/articulo/form-a")
	public String muestraFormVacio(Model model) {
		model.addAttribute("articulo", new Articulo());
		model.addAttribute("tituloH1", "Formulario de artículo");
		return "articulo/form-a";
	}
	
	@PostMapping("/articulo/form-a")
	public String guardaForm(Articulo articulo) {
		articuloService.save(articulo);
		return "redirect:/articulo/todos";
	}
	
	@GetMapping("/articulo/form-a/{id}")
	public String muestraFormConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("articulo", articuloService.findById(id));
		model.addAttribute("tituloH1", "Edición de artículo");
		return "articulo/form-a";
	}
	
	@GetMapping("/articulo/borrar2/{id}")
	public String borrado2PorId(@PathVariable Long id) {
		String restURL = "http://localhost:8080/articulo/delete/rest/id/" + id;
		ResponseEntity<String> response = restTemplate.exchange(restURL, HttpMethod.DELETE, null, String.class);
		if(response.getStatusCode().is2xxSuccessful()) {
			System.out.println("Éxito");
		}else {
			System.out.println("Fracaso");
		}
		return "redirect:/articulo/todos";
	}
	
}
