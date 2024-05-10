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
@Table(name="permiso", schema="public")
public class Permiso {
	
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="permitido")
	private Boolean permitido;
	
	@Column(name="modulo")
	private String modulo;

	@Column(name="usuarioid")
	private Integer usuarioId;
	
	@Column(name="moduloid")
	private Integer moduloId;
}
