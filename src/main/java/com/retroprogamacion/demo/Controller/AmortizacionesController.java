package com.retroprogamacion.demo.Controller;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retroprogamacion.demo.entity.Amortizaciones;
import com.retroprogamacion.demo.service.IAmortizacionesService;

@Controller
@RequestMapping("/amortizaciones")
public class AmortizacionesController {

	@Autowired
	private IAmortizacionesService service;
	
	
	@GetMapping("/Listar")
	public String ListarAmortizaciones(Model model) {
		List<Amortizaciones> amort = service.getAll();
		model.addAttribute("amort",amort);
		return "Amortizaciones/ListarAmortizaciones";
	}
	
	@GetMapping("/Agregar/{id}")
	public String AgregarAmortizaciones(@PathVariable int id, Model model) {
		Optional<Amortizaciones> amort = service.findById(id);
		amort.ifPresent(amorte ->{
			Float mensaulidad = amorte.getMensualidad();
			System.out.println(mensaulidad);
		});

		
		
		System.out.println("Mensualidad");
		model.addAttribute("amort", amort);
		return "/Amortizaciones/Agregar";
	}
	
	@PostMapping("/Guardar")
	public String GuardarAmortizacioens(Amortizaciones a, Model model) {
			
		Optional<Amortizaciones> amorti = service.findById(a.getIdamortizacion());
		amorti.ifPresent( amorte ->{
			Date Fecha = amorte.getFecha_Vencimiento();
			if(Fecha.after(a.getFecha_Vencimiento())) {
				System.out.println("Cambiando Moda");
				Long diferencia = (Fecha.getTime() - a.getFecha_Vencimiento().getTime()) / (1000 * 60 * 60 * 24);
				
				double Mora = diferencia * 0.5;
				double pago = a.getMensualidad() + Mora;
				a.setMensualidad((float) pago);
			}
		});
		
		if(a.getMensualidad() != null) {
			System.out.println("Pago realizado");
			a.setEstado(false);
			service.Pagar(a);
			
			return "redirect:/amortizaciones/Listar";
		}else {
			System.out.println("Error");
			return "/amortizaciones/Agregar/"+a.getIdamortizacion();
		}
		
	}
	
}
