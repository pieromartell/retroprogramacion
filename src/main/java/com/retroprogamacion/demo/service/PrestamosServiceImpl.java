package com.retroprogamacion.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retroprogamacion.demo.entity.Prestamo;
import com.retroprogamacion.demo.repository.IPrestamosRepository;

@Service
public class PrestamosServiceImpl implements IPrestamoService {
	
	@Autowired
	IPrestamosRepository repository;

	@Override
	public List<Prestamo> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Prestamo save(Prestamo p) {
		return repository.save(p);
	}

}
