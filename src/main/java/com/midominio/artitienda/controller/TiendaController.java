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

import com.midominio.artitienda.entity.Tienda;
import com.midominio.artitienda.service.TiendaService;

@Controller
public class TiendaController {

	@Autowired
	private TiendaService tiendaService;
	@Autowired
	private RestTemplate restTemplate;
	
	@ModelAttribute("titulo")
	private String dameTitulo() {
		return "Tiendas";
	}
	
	@GetMapping("/tienda/todas")
	public String listarTodasLasTiendas(Model model) {
		//model.addAttribute("titulo", "Tiendas");
		model.addAttribute("tituloH1", "Listado de tiendas");
		model.addAttribute("cantidad", tiendaService.count());
		model.addAttribute("tiendas", tiendaService.todasLasTiendas());
		return "tienda/lista-tiendas";
	}
	
	@GetMapping("tienda/borrar/{id}")
	public String borrarPorId(@PathVariable Long id) {
		tiendaService.deleteById(id);
		return "redirect:/tienda/todas";
	}
	
	@GetMapping("/tienda/form")
	public String muestraFormVacio(Model model) {
		model.addAttribute("tienda", new Tienda());
		model.addAttribute("tituloH1", "Formulario de tienda");
		return "tienda/form";
	}
	
	@PostMapping("/tienda/form")
	public String guardaForm(Tienda tienda) {
		tiendaService.save(tienda);
		return "redirect:/tienda/todas";
	}
	
	@GetMapping("/tienda/form/{id}")
	public String muestraFormConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("tienda", tiendaService.findById(id));
		model.addAttribute("tituloH1", "Edición de tienda");
		return "tienda/form";
	}
	
	@GetMapping("/tienda/borrar2/{id}")
	public String borrado2PorId(@PathVariable Long id) {
		String restURL = "http://localhost:8080/tienda/delete/rest/id/" + id;
		ResponseEntity<String> response = restTemplate.exchange(restURL, HttpMethod.DELETE, null, String.class);
		if(response.getStatusCode().is2xxSuccessful()) {
			System.out.println("Éxito");
		}else {
			System.out.println("Fracaso");
		}
		return "redirect:/tienda/todas";
	}
	
}
