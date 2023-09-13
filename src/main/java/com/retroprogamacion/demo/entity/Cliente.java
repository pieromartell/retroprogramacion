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
	@Column(name="dnicliente")
	int dnicliente;
	
	
	@Column(name="nombres")
	String nombres;
	
	@Column(name="apellidos")
	String apellidos;
	
	
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
