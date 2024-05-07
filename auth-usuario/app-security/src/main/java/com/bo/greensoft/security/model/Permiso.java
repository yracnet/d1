package com.bo.greensoft.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="tbl_permiso", schema="demo")
public class Permiso {
	
	@Id
	@Column(name="id_permiso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPermiso;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="permitido")
	private Boolean permitido;
	
	@Column(name="modulo")
	private String modulo;

	@Column(name="usuario_id")
	private Integer usuarioId;
}
