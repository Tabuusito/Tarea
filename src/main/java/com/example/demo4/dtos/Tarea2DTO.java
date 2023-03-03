package com.example.demo4.dtos;

import java.io.Serializable;


public class Tarea2DTO implements Serializable, ITarea2{
	private Integer id_pais;
	private String nombre_pais;
	private Integer id_ciudad;
	private String nombre_ciudad;
	private Integer valor;
	private String descripcion_tipo;
	private Integer num_veces_sede;
	
	public Tarea2DTO() {}
	
	public Tarea2DTO(Integer id_pais, String nombre_pais, Integer id_ciudad, String nombre_ciudad,
			Integer valor, String descripcion, Integer veces_sede) {
		this.id_pais = id_pais;
		this.nombre_pais = nombre_pais;
		this.id_ciudad = id_ciudad;
		this.nombre_ciudad = nombre_ciudad;
		this.valor = valor;
		this.descripcion_tipo = descripcion;
		this.num_veces_sede = veces_sede;
	}
	
	@Override
	public Integer getIdPais() {
		return this.id_pais;
	}
	public void setIdPais(Integer id) {
		this.id_pais = id;
	}
	@Override
	public String getNombrePais() {
		return this.nombre_pais;
	}
	public void setNombrePais(String nombre) {
		this.nombre_pais = nombre;
	}
	@Override
	public Integer getIdCiudad() {
		return this.id_ciudad;
	}
	public void setIdCiudad(Integer id) {
		this.id_ciudad = id;
	}
	@Override
	public String getNombreCiudad() {
		return this.nombre_ciudad;
	}
	public void setNombreCiudad(String nombre) {
		this.nombre_ciudad = nombre;
	}
	@Override
	public Integer getValor() {
		return this.valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	@Override
	public String getDescripcion() {
		return this.descripcion_tipo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion_tipo = descripcion;
	}
	@Override
	public Integer getNumVecesSede() {
		return this.num_veces_sede;
	}
	public void setNumVecesSede(Integer num) {
		this.num_veces_sede = num;
	}
	
	@Override
	public String toString() {
		String toret = "";
		toret += "id_pais " + getIdPais();
		toret += "\nnombre_pais " + getNombrePais();
		toret += "\nid_ciudad " + getIdCiudad();
		toret += "\nnombre_ciudad " + getNombreCiudad();
		toret += "\nvalor " + getValor();
		toret += "\ndescripcion " + getDescripcion();
		toret += "\nveces_sede " + getNumVecesSede();
		
		return toret;
	}
	
}