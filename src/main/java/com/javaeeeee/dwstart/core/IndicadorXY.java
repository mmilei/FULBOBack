package com.javaeeeee.dwstart.core;

public class IndicadorXY {
	private String titulo;
	private Float valorX;
	private Float valorY;
	
	public IndicadorXY(String titulo, Float valorX, Float valorY) {
		super();
		this.titulo = titulo;
		this.valorX = valorX;
		this.valorY = valorY;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Float getValorX() {
		return valorX;
	}
	public void setValorX(Float valorX) {
		this.valorX = valorX;
	}
	public Float getValorY() {
		return valorY;
	}
	public void setValorY(Float valorY) {
		this.valorY = valorY;
	}
}
