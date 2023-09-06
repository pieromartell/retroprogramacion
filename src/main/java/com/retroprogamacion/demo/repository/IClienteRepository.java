package com.retroprogamacion.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retroprogamacion.demo.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
