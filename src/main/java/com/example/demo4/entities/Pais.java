package com.example.demo4.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pais implements Serializable {
	@Id
	private Integer id_pais;
	private String nombre_pais;
	private String codigo_pais;
	private Integer valor_pais;

	public Pais() {
	}

	public Pais(Integer id, String nombre, String codigo_pais, Integer valor) {
		this.id_pais = id;
		this.nombre_pais = nombre;
		this.codigo_pais = codigo_pais;
		this.valor_pais = valor;
	}

	public Integer getId() {
		return this.id_pais;
	}

	public void setId(Integer id) {
		this.id_pais = id;
	}

	public String getNombre() {
		return this.nombre_pais;
	}

	public void setNombre(String nombre) {
		this.nombre_pais = nombre;
	}

	public String getCodigo() {
		return this.codigo_pais;
	}

	public void setCodigo(String codigo) {
		this.codigo_pais = codigo;
	}

	public Integer getValor() {
		return this.valor_pais;
	}

	public void setValor(Integer valor) {
		this.valor_pais = valor;
	}
}
