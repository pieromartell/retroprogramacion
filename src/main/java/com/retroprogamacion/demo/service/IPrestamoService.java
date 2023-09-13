package com.retroprogamacion.demo.service;

import java.util.List;

import com.retroprogamacion.demo.entity.Prestamo;
import com.retroprogamacion.demo.repository.IPrestamosRepository;

public interface IPrestamoService {

	List<Prestamo> getAll();
	
	Prestamo save(Prestamo p);
	
}
