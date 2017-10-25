package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {
	public static final int CANCELADO=0;
	public static final int ABIERTO=1;
	public static final int OK_CONSULTOR=2;
	public static final int DERIVADO=3;
	public static final int SUSPENDIDO=4;
	public static final int INGRESADO=5;
	public static final int CERRADO=8;

	private Integer id;
	private String titulo;
	private String descripcion;
	private String tipoModulo;
	private String tipoModuloDescripcion;
	private String modulo;
	private String moduloDescripcion;
	private Integer cliente;
	private String programa;
	private String fechaAlta;
	private String fechaCierre;
	private Integer estado;
	private String estadoDescripcion;
	private Integer tipo;
	private String tipoDescripcion;
	private Float horasInvertidas;
	private String nombreContacto;
	private String telefonoContacto;
	private String emailContacto;
	private List<TicketDetalle> ticketDetalle;
	private List<Programa> programas;
	private Calificacion calificacion;
	private String tieneAdjunto;
	private String consultorAsignado;
	private String emailConsultorAsignado;
	private String enPoderDelCliente;
	private String calificacionPendiente;

	public Ticket() {
		super();
	}

	public Ticket(Integer id, String titulo, String descripcion, String modulo, String moduloDescripcion, Integer cliente, String programa,
				  String fechaAlta, String fechaCierre, Integer estado, String estadoDescripcion, Integer tipo, String tipoDescripcion,
				  Float horasInvertidas, String nombreContacto, String telefonoContacto, String emailContacto, String tieneAdjunto,
				  String consultorAsignado, String emailConsultorAsignado, String enPoderDelCliente) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.modulo = modulo;
		this.moduloDescripcion = moduloDescripcion;
		this.cliente = cliente;
		this.programa = programa;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.estado = estado;
		this.estadoDescripcion = estadoDescripcion;
		this.tipo = tipo;
		this.tipoDescripcion = tipoDescripcion;
		this.horasInvertidas = horasInvertidas;
		this.nombreContacto = nombreContacto;
		this.telefonoContacto = telefonoContacto;
		this.emailContacto = emailContacto;
		this.tieneAdjunto = tieneAdjunto;
		this.consultorAsignado = consultorAsignado;
		this.emailConsultorAsignado = emailConsultorAsignado;
		this.enPoderDelCliente = enPoderDelCliente;
	}

	public Ticket(Integer id, String titulo, String moduloDescripcion, String fechaAlta, String fechaCierre, String estadoDescripcion,
				  String calificacionPendiente) {
		this.id = id;
		this.titulo = titulo;
		this.moduloDescripcion = moduloDescripcion;
		this.fechaAlta = fechaAlta;
		this.fechaCierre = fechaCierre;
		this.estadoDescripcion = estadoDescripcion;
		this.calificacionPendiente = calificacionPendiente;
	}

	public Ticket(Integer id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public String getTipoModulo() {
		return tipoModulo;
	}

	public void setTipoModulo(String tipoModulo) {
		this.tipoModulo = tipoModulo;
	}

	public String getTipoModuloDescripcion() {
		return tipoModuloDescripcion;
	}

	public void setTipoModuloDescripcion(String tipoModuloDescripcion) {
		this.tipoModuloDescripcion = tipoModuloDescripcion;
	}

	public Float getHorasInvertidas() {
		return horasInvertidas;
	}

	public void setHorasInvertidas(Float horasInvertidas) {
		this.horasInvertidas = horasInvertidas;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getModuloDescripcion() {
		return moduloDescripcion;
	}

	public void setModuloDescripcion(String moduloDescripcion) {
		this.moduloDescripcion = moduloDescripcion;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}

	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getTipoDescripcion() {
		return tipoDescripcion;
	}

	public void setTipoDescripcion(String tipoDescripcion) {
		this.tipoDescripcion = tipoDescripcion;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public List<TicketDetalle> getTicketDetalle() {
		return ticketDetalle;
	}

	public void setTicketDetalle(List<TicketDetalle> ticketDetalle) {
		this.ticketDetalle = ticketDetalle;
	}

	public List<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	public String getTieneAdjunto() {
		return tieneAdjunto;
	}

	public void setTieneAdjunto(String tieneAdjunto) {
		this.tieneAdjunto = tieneAdjunto;
	}

	public String getConsultorAsignado() {
		return consultorAsignado;
	}

	public void setConsultorAsignado(String consultorAsignado) {
		this.consultorAsignado = consultorAsignado;
	}

	public String getEmailConsultorAsignado() {
		return emailConsultorAsignado;
	}

	public void setEmailConsultorAsignado(String emailConsultorAsignado) {
		this.emailConsultorAsignado = emailConsultorAsignado;
	}

	public String getEnPoderDelCliente() {
		return enPoderDelCliente;
	}

	public void setEnPoderDelCliente(String enPoderDelCliente) {
		this.enPoderDelCliente = enPoderDelCliente;
	}

	public String getCalificacionPendiente() {
		return calificacionPendiente;
	}

	public void setCalificacionPendiente(String calificacionPendiente) {
		this.calificacionPendiente = calificacionPendiente;
	}
}