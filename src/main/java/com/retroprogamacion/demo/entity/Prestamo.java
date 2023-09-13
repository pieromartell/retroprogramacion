package com.retroprogamacion.demo.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prestamos")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idprestamo")
	int idprestamo;
	
	@Column(name="fecha_prestamo")
	String fecha_prestamo;
	
	@Column(name="monto")
	Float monto;
	
	@Column(name="interes")
	Float interes;
	
	@Column(name="nrocuatas")
	int nrocuatas;
	
	@ManyToOne
	@JoinColumn(name="dnicliente")
	 Cliente cliente;

}
