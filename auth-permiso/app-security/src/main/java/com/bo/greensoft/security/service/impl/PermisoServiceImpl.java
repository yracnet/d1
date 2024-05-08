package com.bo.greensoft.security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bo.greensoft.security.model.Permiso;
import com.bo.greensoft.security.repository.PermisoRepository;
import com.bo.greensoft.security.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService{

	PermisoRepository permisoRepository;
	
	public PermisoServiceImpl(PermisoRepository permisoRepository) {
		this.permisoRepository = permisoRepository;
	}

	@Override
	public Permiso save(Permiso permiso) {
		Integer P_id = this.permisoRepository.findMaxPid();
		permiso.setId(P_id+1);
		return this.permisoRepository.save(permiso);
	}

	@Override
	public Permiso update(Permiso permiso, Integer id) {
		Permiso permisoBean = this.permisoRepository.findById(id).get();
		permisoBean.setModulo(permiso.getModulo());
		permisoBean.setPermitido(permiso.getPermitido());
		permisoBean.setUsuarioId(permiso.getUsuarioId());
		return this.permisoRepository.save(permisoBean);
	}

	@Override
	public Permiso finById(Integer id) {
		Permiso bean = this.permisoRepository.findById(id).get();
		return bean;
	}

	@Override
	public List<Permiso> findAll() {
		return this.permisoRepository.findAll();
	}

	@Override
	public Permiso delete(Integer id) {
		Permiso bean = this.permisoRepository.findById(id).get();
		this.permisoRepository.delete(bean);
		return bean;
	}

}
