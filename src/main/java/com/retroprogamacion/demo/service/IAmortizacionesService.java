package com.retroprogamacion.demo.service;

import java.util.List;
import java.util.Optional;

import com.retroprogamacion.demo.entity.Amortizaciones;

public interface IAmortizacionesService {
	
	List<Amortizaciones> getAll();
	
	Amortizaciones Pagar(Amortizaciones a);
	
	Optional<Amortizaciones> findById(int id);

}
