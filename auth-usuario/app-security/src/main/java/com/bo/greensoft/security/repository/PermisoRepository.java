package com.bo.greensoft.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bo.greensoft.security.model.Permiso;

@Repository
public interface PermisoRepository  extends JpaRepository<Permiso, Integer>{

}
