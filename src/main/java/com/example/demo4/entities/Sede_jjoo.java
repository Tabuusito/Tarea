package com.example.demo4.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Sede_jjoo implements Serializable{
	@Id
	private Integer año;
	@ManyToOne
	private Tipo_jjoo tipo_jjoo;
	@ManyToOne
	private Ciudad sede;
	
	public Sede_jjoo() {}
	
	public Sede_jjoo(Integer año, Tipo_jjoo tipo, Ciudad sede) {
		this.año = año;
		this.tipo_jjoo = tipo;
		this.sede = sede;
	}
	
	public Integer getAnho() {
		return this.año;
	}
	public void setAnho(Integer año) {
		this.año = año;
	}
	public Tipo_jjoo getTipo() {
		return this.tipo_jjoo;
	}
	public void setTipo(Tipo_jjoo tipo) {
		this.tipo_jjoo = tipo;
	}
	public Ciudad getSede() {
		return this.sede;
	}
	public void setSede(Ciudad sede) {
		this.sede = sede;
	}
}	
	
