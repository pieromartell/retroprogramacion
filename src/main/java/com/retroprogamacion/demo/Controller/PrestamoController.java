package com.retroprogamacion.demo.Controller;

import java.util.List;
import java.util.Optional;

import com.retroprogamacion.demo.entity.Prestamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retroprogamacion.demo.service.IPrestamoService;



@Controller
@RequestMapping("/Prestamos")
public class PrestamoController {

	@Autowired
	private IPrestamoService service;
	
	@GetMapping("/ListarPrestamos")
	public String Prestamo(Model model ) {
		List<Prestamo> prestamos = service.getAll();
	    //prestamos.forEach(prestamo -> prestamo.setDnicliente(clienteService.getByDni(prestamo.getDnicliente())));
		model.addAttribute("prestamo",prestamos);
		return "/Prestamos/ListadoPrestamos";
	}
	
	@GetMapping("/agregarPrestamo")
	public String AgregarPrestamo(Model model) {
		model.addAttribute("Prestamo",new Prestamo());
		return "/Prestamos/Agregar";
	}
	
	@PostMapping("/GuardarPrestamo")
	public String SavePrestamo(Prestamo p, Model model) {
		System.out.println("Prestamo" + p);
		service.save(p);
		return "redirect:/Prestamos/ListarPrestamos";
	}
	
	
}
