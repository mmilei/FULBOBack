package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.security.Principal;

public class User implements Principal{

	private int id;
	private String usuario;

	@JsonIgnore
	private String contrasenia;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private int idCliente;
	private String token;
	private String rol;

	public User(int id, String usuario, String nombre, String apellido, String email, String telefono, int idCliente, String rol) {
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.idCliente = idCliente;
		this.rol = rol;
	}

	public User(int id, int idCliente) {
		this.id = id;
		this.idCliente = idCliente;
	}

	public User(int id, String usuario, String contrasenia, String nombre, String apellido, String email, String telefono, int idCliente, String token) {
		this.id = id;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.idCliente = idCliente;
		this.token = token;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getTelefono() {

		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public User(int id, String usuario, String contrasenia, String nombre, String apellido, String email) {
		this.id = id;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String usuario, String contrasenia) {
		this.id = id;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public User(String nombre) {
		super();
		this.nombre = nombre;
	}
	@JsonIgnore
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
