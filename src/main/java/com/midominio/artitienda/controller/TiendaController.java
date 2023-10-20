package com.midominio.artitienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.midominio.artitienda.entity.Tienda;
import com.midominio.artitienda.service.TiendaService;

@Controller
public class TiendaController {

	@Autowired
	private TiendaService tiendaService;
	
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
	
}
