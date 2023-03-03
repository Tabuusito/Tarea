package com.example.demo4.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ciudad implements Serializable {
	@Id
	private Integer id_ciudad;
	private String nombre_ciudad;

	@ManyToOne
	private Pais pais;
	private Integer valor_ciudad;

	public Ciudad() {
	}

	public Ciudad(Integer id, String nombre, Pais pais, Integer valor) {
		this.id_ciudad = id;
		this.nombre_ciudad = nombre;
		this.pais = pais;
		this.valor_ciudad = valor;
	}

	public Integer getId() {
		return this.id_ciudad;
	}

	public void setId(Integer id) {
		this.id_ciudad = id;
	}

	public String getNombre() {
		return this.nombre_ciudad;
	}

	public void setNombre(String nombre) {
		this.nombre_ciudad = nombre;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getValor() {
		return this.valor_ciudad;
	}

	public void setValor(Integer valor) {
		this.valor_ciudad = valor;
	}
}
