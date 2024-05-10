package com.bo.greensoft.security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bo.greensoft.security.model.Modulo;
import com.bo.greensoft.security.repository.ModuloRepository;
import com.bo.greensoft.security.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService{

	ModuloRepository moduloRepository;
	
	public ModuloServiceImpl(ModuloRepository moduloRepository) {
		this.moduloRepository = moduloRepository;
	}
	
	@Override
	public Modulo save(Modulo modulo) {
		Integer M_id = this.moduloRepository.findMaxMid();
		modulo.setId(M_id+1);
		return this.moduloRepository.save(modulo);
	}

	@Override
	public Modulo update(Modulo modulo, Integer id) {
		Modulo moduloBean = this.moduloRepository.findById(id).get();
		moduloBean.setNombre(modulo.getNombre());
		moduloBean.setCodigo(modulo.getCodigo());
		return this.moduloRepository.save(moduloBean);
	}

	@Override
	public Modulo finById(Integer id) {
		Modulo bean = this.moduloRepository.findById(id).get();
		return bean;
	}

	@Override
	public List<Modulo> findAll() {
		return this.moduloRepository.findAll();
	}

	@Override
	public Modulo delete(Integer id) {
		Modulo bean = this.moduloRepository.findById(id).get();
		this.moduloRepository.delete(bean);
		return bean;
	}

}
