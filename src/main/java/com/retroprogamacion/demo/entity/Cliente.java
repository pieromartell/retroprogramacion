package com.retroprogamacion.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;


@Entity
@Table(name="Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcliente")
	int idcliente;
	
	
	@Column(name="nombres")
	String nombres;
	
	@Column(name="apellidos")
	String apellidos;
	
	@Column(name="dni")
	String dni;
	
	@Column(name="direccion")
	String direccion;
	
	@Column(name="distrito")
	String distrito;
	
	@Column(name="provincia")
	String provincia;

	@Column(name="telefono")
	int telefono;
	
	@Column(name="correo")
	String correo;
	
	
	@Column(name="estado")
	Boolean estado;
	
}
