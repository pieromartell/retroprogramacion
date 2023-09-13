package com.retroprogamacion.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retroprogamacion.demo.entity.Cliente;
import com.retroprogamacion.demo.repository.IClienteRepository;


@Service
public class ClienteServiceImpl implements IClienteService {

	
	 @Autowired
	 private IClienteRepository repository;
	
	@Override
	public List<Cliente> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public Cliente add(Cliente c) {
		return repository.save(c);
	}

	@Override
	public Cliente update(Cliente c) {	
		Cliente obj = repository.getById(c.getDnicliente());
		BeanUtils.copyProperties(c, obj);
		return repository.save(c);
	}

	@Override
	public Cliente delete(Cliente c) {
		Cliente obj = repository.getById(c.getDnicliente());
		obj.setEstado(false);
		return repository.save(obj);
	}

}
