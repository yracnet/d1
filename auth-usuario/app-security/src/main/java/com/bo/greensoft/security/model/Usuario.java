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
@Table(name="usuario", schema="public")
public class Usuario {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name="nombres")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="descripcion")
	private String descripcion;
	
}
