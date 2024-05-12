package com.bo.greensoft.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bo.greensoft.security.model.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Integer>{

	@Query(value = "SELECT MAX(m.id) FROM public.modulo m", nativeQuery = true, countQuery = "select count(*) from public.modulo")
	public Integer findMaxMid();
	
}
