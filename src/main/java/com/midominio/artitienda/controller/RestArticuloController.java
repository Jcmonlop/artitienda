package com.midominio.artitienda.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.artitienda.entity.Articulo;
import com.midominio.artitienda.service.ArticuloService;

@RestController
public class RestArticuloController {
	@Autowired
	ArticuloService articuloService;

	@GetMapping("/listar-rest")
	public Iterable<Articulo> listarRest(){
			return articuloService.todosLosArticulos();
	}
	
	@GetMapping("/rest/id/{id}")
	public Optional<Articulo> findById(@PathVariable Long id) {
		return articuloService.findById(id);
	}
	
	@DeleteMapping("/articulo/delete/rest/id/{id}")
	public void deleteById(@PathVariable Long id) {
		articuloService.deleteById(id);
	}
	
	@PostMapping("/articulo/rest")
	public Articulo crear(@RequestBody Articulo articulo) {
		return articuloService.save(articulo);
	}
	
	@PutMapping("/articulo")
	public Articulo actualizar(Articulo articulo) {
		return articuloService.save(articulo);
	}
	
}
