package com.midominio.artitienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.artitienda.dao.TiendaRepository;

@Service
public class TiendaService {
	@Autowired
	private TiendaRepository tiendaRepository;
	
	public long count() {
		return tiendaRepository.count();
	}
}
