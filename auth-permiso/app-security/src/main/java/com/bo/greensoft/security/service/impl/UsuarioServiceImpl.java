package com.bo.greensoft.security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bo.greensoft.security.model.Usuario;
import com.bo.greensoft.security.repository.UsuarioRepository;
import com.bo.greensoft.security.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario save(Usuario usuario) {
		Integer U_id = this.usuarioRepository.findMaxUid();
		usuario.setId(U_id+1);
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario, Integer id) {
		Usuario usuarioBean = this.usuarioRepository.findById(id).get();
		usuarioBean.setNombres(usuario.getNombres());
		usuarioBean.setApellidos(usuario.getApellidos());
		usuarioBean.setDescripcion(usuario.getDescripcion());
		usuarioBean.setEmail(usuario.getEmail());
		return this.usuarioRepository.save(usuarioBean);
	}

	@Override
	public Usuario finById(Integer id) {
		Usuario bean = this.usuarioRepository.findById(id).get();
		return bean;
	}

	@Override
	public List<Usuario> findAll() {
		
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario delete(Integer id) {
		Usuario bean = this.usuarioRepository.findById(id).get();
		this.usuarioRepository.delete(bean);
		return bean;
	}

}
