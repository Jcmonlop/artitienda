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

import com.midominio.artitienda.entity.Tienda;
import com.midominio.artitienda.service.TiendaService;

@RestController
public class RestTiendaController {

	@Autowired
	TiendaService tiendaService;
	
	
	@GetMapping("/tienda/rest/all")
	public Iterable<Tienda> listarTiendas() {
		return tiendaService.todasLasTiendas();
	}
	
	
	@GetMapping("/tienda/rest/id/{id}")
	public Optional<Tienda> findById(@PathVariable Long id) {
		return tiendaService.findById(id);
	}
	
	@DeleteMapping("/tienda/delete/rest/id/{id}")
	public void deleteById(@PathVariable Long id) {
		tiendaService.deleteById(id);
	}
	
	@PostMapping("/tienda/rest")
	public Tienda crear(@RequestBody Tienda tienda) {
		return tiendaService.save(tienda);
	}
	
	@PutMapping("/tienda")
	public Tienda actualizar(Tienda tienda) {
		return tiendaService.save(tienda);
	}
}
