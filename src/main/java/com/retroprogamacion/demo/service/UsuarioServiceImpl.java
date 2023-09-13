package com.retroprogamacion.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retroprogamacion.demo.entity.Usuario;
import com.retroprogamacion.demo.repository.IUsuariosRepository;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

	
	@Autowired
	private IUsuariosRepository repository;
	
	
	@Override
	public Usuario findByUsernameAndPassword(String Username, String Password) {
		
		return repository.findUsuarioByUsernameAndPassword(Username,Password);
	}



}
