package com.retroprogamacion.demo.service;

import java.util.List;
import java.util.Optional;

import com.retroprogamacion.demo.entity.Cliente;

public interface IClienteService {

	List<Cliente> getAll();
	
	Optional<Cliente> findById(int id);
	
	Cliente add(Cliente c);
	
	Cliente update(Cliente c);
	
	Cliente delete(Cliente c);
	
}
