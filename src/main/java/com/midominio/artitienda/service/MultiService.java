package com.midominio.artitienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.artitienda.dao.ArticuloRepository;
import com.midominio.artitienda.dao.TiendaRepository;

@Service
public class MultiService {
	
	@Autowired
	ArticuloRepository articuloRepository;
	@Autowired
	TiendaRepository tiendaRepository;
	
	public void destruyeElMundo() {
		articuloRepository.deleteAll();
		tiendaRepository.deleteAll();
	}
	
}
