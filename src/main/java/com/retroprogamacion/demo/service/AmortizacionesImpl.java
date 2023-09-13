package com.retroprogamacion.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retroprogamacion.demo.entity.Amortizaciones;
import com.retroprogamacion.demo.repository.IAmortizacionesRepository;

@Service
public class AmortizacionesImpl implements IAmortizacionesService {

	@Autowired
	IAmortizacionesRepository repository;
	
	
	@Override
	public List<Amortizaciones> getAll() {
		return repository.findAll();
	}


	@Override
	public Amortizaciones Pagar(Amortizaciones a) {
		Amortizaciones obj = repository.getById(a.getIdamortizacion());
		obj.setEstado(false);
		return repository.save(obj);
	}


	@Override
	public Optional<Amortizaciones> findById(int id) {
		return repository.findById(id);
	}

}
