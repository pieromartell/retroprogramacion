package com.retroprogamacion.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retroprogamacion.demo.entity.Cliente;
import com.retroprogamacion.demo.service.IClienteService;

import ch.qos.logback.core.net.server.Client;



@Controller
@RequestMapping
public class ClienteController {

	
	@Autowired
	private IClienteService service;
	
	
	@GetMapping("/Index")
	public String mostrarIndex() {
		return "Index";
	}
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente> cliente = service.getAll();
		model.addAttribute("cliente", cliente);
		return "Cliente/ListarCliente";
	}
	
	@GetMapping("/agregar")
	public String Agregar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/formulario";
	}
	
	@PostMapping("/save")
	public String save( Cliente c, Model model) {
		service.add(c);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String Editar(@PathVariable int id, Model model) {
		Optional<Cliente> cliente = service.findById(id);
		model.addAttribute("cliente", cliente);
		return "cliente/editar";
	}
	
	@PostMapping("/update")
	public String update( Cliente c, Model model) {
		
		service.update(c);
		return "redirect:/listar";
	}
	
	@PostMapping("/Eliminar/{id}")
	public String delete( Model model, @PathVariable int id) {
		return "redirect:/listar";
	}
	
}
