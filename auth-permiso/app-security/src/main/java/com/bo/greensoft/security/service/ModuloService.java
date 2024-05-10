package com.bo.greensoft.security.service;

import java.util.List;

import com.bo.greensoft.security.model.Modulo;

public interface ModuloService {

	public Modulo save(Modulo modulo);
	public Modulo update(Modulo modulo, Integer id);
	public Modulo finById(Integer  id);
	public List<Modulo> findAll();
	public Modulo delete(Integer  id);
}
