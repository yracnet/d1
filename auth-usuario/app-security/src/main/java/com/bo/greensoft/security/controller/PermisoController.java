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

import com.bo.greensoft.security.model.Permiso;
import com.bo.greensoft.security.service.PermisoService;

@RestController
@RequestMapping("/permiso")
@CrossOrigin("*")
public class PermisoController {

	private PermisoService permisoService;

	public PermisoController(PermisoService permisoService) {
		this.permisoService = permisoService;
	}

	@GetMapping("/findAll")
	public List<Permiso> findAll(){
		return this.permisoService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Permiso findById(@PathVariable Integer id) {
		return this.permisoService.finById(id);
	}
	
	@PostMapping("/save")
	public Permiso save(@Valid @RequestBody Permiso permiso) {
		return this.permisoService.save(permiso);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Permiso> update(@RequestBody Permiso permiso, @PathVariable Integer id) {
		return new ResponseEntity<Permiso>(this.permisoService.update(permiso, id), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Permiso> delete(@PathVariable Integer id) {
		return new ResponseEntity<Permiso>(this.permisoService.delete(id), HttpStatus.OK);
	}
}
