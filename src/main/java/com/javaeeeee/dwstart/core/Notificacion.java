package com.javaeeeee.dwstart.core;

import java.util.Date;

public class Notificacion {
	private int id;
	private int idCliente;
	private String titulo;
	private String descripcion;
	private String fechaAlta;
	private String leido;

	public Notificacion(int id, int idCliente, String titulo, String descripcion, String fechaAlta, String leido) {
		this.id = id;
		this.idCliente = idCliente;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
		this.leido = leido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getLeido() {
		return leido;
	}

	public void setLeido(String leido) {
		this.leido = leido;
	}
}
