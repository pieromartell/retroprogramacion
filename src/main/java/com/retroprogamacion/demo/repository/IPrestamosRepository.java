package com.retroprogamacion.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retroprogamacion.demo.entity.Prestamo;

public interface IPrestamosRepository extends JpaRepository<Prestamo, Integer> {

}
