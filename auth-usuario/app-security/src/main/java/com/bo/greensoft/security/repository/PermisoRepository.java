package com.bo.greensoft.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.bo.greensoft.security.model.Permiso;

@Repository
public interface PermisoRepository  extends JpaRepository<Permiso, Integer>{
	
	@Query(value = "SELECT MAX(p.id) FROM public.permiso p", nativeQuery = true, countQuery = "select count(*) from public.permiso")
	public Integer findMaxPid();
	
}
