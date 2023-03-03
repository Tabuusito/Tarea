package com.example.demo4.entities;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Tipo_jjoo implements Serializable{
	
	@Id
	private Integer id_tipo_jjoo;
	private String descripcion_tipo;
	
	public Tipo_jjoo() {}
	
	public Tipo_jjoo(Integer id, String descripcion) {
		this.id_tipo_jjoo = id;
		this.descripcion_tipo = descripcion;
	}
	
	public Integer getId() {
		return this.id_tipo_jjoo;
	}
	public void setId(Integer id) {
		this.id_tipo_jjoo = id;
	}
	public String getDescripcion() {
		return this.descripcion_tipo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion_tipo = descripcion;
	}
}
