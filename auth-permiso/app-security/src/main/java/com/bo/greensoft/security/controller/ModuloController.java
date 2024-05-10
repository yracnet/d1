package com.bo.greensoft.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
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

import com.bo.greensoft.security.model.Modulo;
import com.bo.greensoft.security.service.ModuloService;

@RestController
@RequestMapping("/modulo")
@CrossOrigin("*")
public class ModuloController {

	private ModuloService moduloService;

	public ModuloController(ModuloService moduloService) {
		this.moduloService = moduloService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Modulo>> findAll(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Total-Count", "15");
		return new ResponseEntity<List<Modulo>>(this.moduloService.findAll(), headers,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Modulo findById(@PathVariable Integer id) {
		return this.moduloService.finById(id);
	}
	
	@PostMapping("/")
	public Modulo save(@Valid @RequestBody Modulo modulo) {
		return this.moduloService.save(modulo);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Modulo> update(@RequestBody Modulo modulo, @PathVariable Integer id) {
		return new ResponseEntity<Modulo>(this.moduloService.update(modulo, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Modulo> delete(@PathVariable Integer id) {
		return new ResponseEntity<Modulo>(this.moduloService.delete(id), HttpStatus.OK);
	}
}
