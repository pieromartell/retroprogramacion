package com.retroprogamacion.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Amortizaciones")
public class Amortizaciones {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="idamortizacion")
	int idamortizacion;

	@Column(name="fecha_Vencimiento")
	Date fecha_Vencimiento;
	
	@Column(name="mensualidad")
	Float mensualidad;
	
	@Column(name="intereses")
	Float intereses;
	
	@Column(name="capital")
	Float capital;
	
	@Column(name="saldo")
	Float saldo;
	
	@Column(name="estado")
	Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="idprestamo")
	private Prestamo prestamos;

}
