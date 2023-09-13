package com.retroprogamacion.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.retroprogamacion.demo.entity.Usuario;

public interface IUsuariosRepository extends JpaRepository<Usuario,Integer > {
	
	Usuario findUsuarioByUsernameAndPassword( @Param("username") String Username, @Param("passowrd")String password);
	

}
