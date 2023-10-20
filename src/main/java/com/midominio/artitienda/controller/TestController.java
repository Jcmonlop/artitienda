package com.midominio.artitienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.midominio.artitienda.dao.ArticuloRepository;
import com.midominio.artitienda.service.ArticuloService;
//import com.midominio.artitienda.dao.TiendaRepository;
import com.midominio.artitienda.service.MultiService;
import com.midominio.artitienda.service.TiendaService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	ArticuloService articuloService;
	@Autowired
	TiendaService tiendaService;
	@Autowired
	MultiService multiService;
	
	@GetMapping("/test1")
	public String test1(Model model) {
		model.addAttribute("titulo", "Test");
		model.addAttribute("numArticulos", articuloService.count());
		model.addAttribute("numTiendas", tiendaService.count());
		return "test/test1";
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("titulo", "Test");
		articuloService.deleteAll();
		model.addAttribute("numArticulos", articuloService.count());
		model.addAttribute("numTiendas", tiendaService.count());
		return "test/test1";
	}
	
	@GetMapping("/test3")
	public String test3(@RequestParam Long id ,Model model) {
		model.addAttribute("titulo", "Existencias");
		if(articuloService.existsById(id)) {
			model.addAttribute("resultado", "El id = " + id + " si existe");
		}else {
			model.addAttribute("resultado", "El id = " + id + " no existe");
		}
		return "test/existencia-articulo";
	}
	
	@GetMapping("/test4/id/{id}")
	public String test4(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Existencias");
		if(articuloService.existsById(id)) {
			model.addAttribute("resultado", "El id = " + id + " si existe");
		}else {
			model.addAttribute("resultado", "El id = " + id + " no existe");
		}
		return "test/existencia-articulo";
	}
	
	@GetMapping("/test5")
	public String test5(Model model) {
		model.addAttribute("titulo", "Listado");
		model.addAttribute("tituloH1", "Lista de artículos");
		model.addAttribute("articulos", articuloService.todosLosArticulos());
		return "test/lista-articulos";
	}
	
	@GetMapping("/test6")
	public String test6(@RequestParam Long id , Model model) {
		model.addAttribute("titulo", "Borrar artículo");
		articuloService.deleteById(id);
		model.addAttribute("articulos", articuloService.todosLosArticulos());
		return "test/lista-articulos";
	}
	
	@GetMapping("/test7")
	public String test7(@RequestParam Long id , Model model) {
		model.addAttribute("titulo", "Mostrar artículo");
		model.addAttribute("articulo", articuloService.findById(id).orElse(null));
		model.addAttribute("idPedido", id);
		return "test/articulo";
	}
	
	@GetMapping("/test100")
	public String test100(Model model) {
		multiService.destruyeElMundo();
		model.addAttribute("titulo", "Destruir");
		model.addAttribute("numArticulos", articuloService.count());
		model.addAttribute("numTiendas", tiendaService.count());
		return "test/test1";
	}
}
