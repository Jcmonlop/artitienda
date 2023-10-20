package com.midominio.artitienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.artitienda.dao.ArticuloRepository;
import com.midominio.artitienda.entity.Articulo;


@Service
public class ArticuloService {
	@Autowired
	ArticuloRepository articuloRepository;
	
	public long count() {
		return articuloRepository.count();
	}
	
	public boolean existsById(Long id) {
		return articuloRepository.existsById(id);
	}
	
	public Iterable<Articulo> todosLosArticulos() {
		return articuloRepository.findAll();
	}
	
	public void deleteAll() {
		articuloRepository.deleteAll();
	}
	
	public Optional<Articulo> findById(Long id) {
		return articuloRepository.findById(id);
	}
	
	public Articulo save(Articulo articulo) {
		return articuloRepository.save(articulo);
	}
	
	public void deleteById(Long id) {
		articuloRepository.deleteById(id);
	}
}
