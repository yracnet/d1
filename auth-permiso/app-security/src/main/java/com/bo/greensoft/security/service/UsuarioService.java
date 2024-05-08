package com.bo.greensoft.security.service;

import java.util.List;

import com.bo.greensoft.security.model.Usuario;

public interface UsuarioService {

	public Usuario save(Usuario usuario);
	public Usuario update(Usuario usuario, Integer id);
	public Usuario finById(Integer  id);
	public List<Usuario> findAll();
	public Usuario delete(Integer  id);
}
