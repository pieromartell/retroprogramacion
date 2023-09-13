package com.retroprogamacion.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retroprogamacion.demo.dao.UsuarioDao;
import com.retroprogamacion.demo.entity.Usuario;
import com.retroprogamacion.demo.service.IUsuarioService;
@Controller
@RequestMapping
public class UsuarioController {

	
	@Autowired
	private IUsuarioService service;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuarioDao usuario) {
		String username = usuario.getUsername();
		String password = usuario.getPassword();
		
		System.out.println(username);
		System.out.println(password);
		
		Usuario user = service.findByUsernameAndPassword(username, password);
		
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
		}
		
		return ResponseEntity.ok(user);	
	}
}
