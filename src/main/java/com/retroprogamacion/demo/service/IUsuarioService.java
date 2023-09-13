package com.retroprogamacion.demo.service;

import com.retroprogamacion.demo.entity.Usuario;

public interface IUsuarioService {

	Usuario findByUsernameAndPassword(String Username, String Password);
	
	
}
