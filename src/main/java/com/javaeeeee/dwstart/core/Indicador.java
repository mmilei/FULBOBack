package com.javaeeeee.dwstart.core;

public class Indicador {
	private int id;
	private String titulo;
	private String descripcion;
	private Float valor;
	
	public Indicador(int id, String titulo, String descripcion, Float valor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
