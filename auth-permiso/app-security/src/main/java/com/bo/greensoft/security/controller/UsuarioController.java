package com.bo.greensoft.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.greensoft.security.model.Usuario;
import com.bo.greensoft.security.service.UsuarioService;

@RestController
@RequestMapping("/api/v2/usuario")
@CrossOrigin("*")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("")
	public List<Usuario> findAll(){
		return this.usuarioService.findAll();
	}
	
	@GetMapping("{id}")
	public Usuario findById(@PathVariable Integer id) {
		return this.usuarioService.finById(id);
	}
	
	@PostMapping("")
	public Usuario save(@Valid @RequestBody Usuario usuario) {
		return this.usuarioService.save(usuario);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Integer id) {
		return new ResponseEntity<Usuario>(this.usuarioService.update(usuario, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
		return new ResponseEntity<Usuario>(this.usuarioService.delete(id), HttpStatus.OK);
	}
}
