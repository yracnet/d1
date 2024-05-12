package com.bo.greensoft.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bo.greensoft.security.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT MAX(u.id) FROM public.usuario u", nativeQuery = true, countQuery = "select count(*) from public.usuario")
	public Integer findMaxUid();
}
