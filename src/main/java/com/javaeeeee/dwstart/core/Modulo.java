package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Modulo {
	private String codigo;
	private String nombre;

	public String getCodigo() {
		return codigo;
	}
	public Modulo(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
