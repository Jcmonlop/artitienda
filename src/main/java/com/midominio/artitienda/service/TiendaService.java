package com.midominio.artitienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.artitienda.dao.TiendaRepository;
import com.midominio.artitienda.entity.Tienda;

@Service
public class TiendaService {
	@Autowired
	private TiendaRepository tiendaRepository;
	
	public long count() {
		return tiendaRepository.count();
	}
	
	public void deleteById(Long id) {
		tiendaRepository.deleteById(id);
	}
	
	public Iterable<Tienda> todasLasTiendas() {
		return tiendaRepository.findAll();
	}
	
	public Tienda save(Tienda tienda) {
		return tiendaRepository.save(tienda);
	}
	
	public Optional<Tienda> findById(Long id) {
		return tiendaRepository.findById(id);
	}
}
