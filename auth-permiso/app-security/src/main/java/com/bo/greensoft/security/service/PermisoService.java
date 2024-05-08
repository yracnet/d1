package com.bo.greensoft.security.service;

import java.util.List;

import com.bo.greensoft.security.model.Permiso;

public interface PermisoService {

	public Permiso save(Permiso permiso);
	public Permiso update(Permiso permiso, Integer id);
	public Permiso finById(Integer  id);
	public List<Permiso> findAll();
	public Permiso delete(Integer  id);
}
