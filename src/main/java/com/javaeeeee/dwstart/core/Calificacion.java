package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Calificacion {
    private Integer id;
    private Integer puntaje;
    private String comentario;
    private Integer idTicket;
    private Integer proyectoEmpresa;
    private Integer proyectoCodigo;
    private String fecha;
    private String usuario;

    public Calificacion() {
    }

    public Calificacion(Integer id, Integer puntaje, String comentario, Integer idTicket, Integer proyectoEmpresa, Integer proyectoCodigo, String fecha, String usuario) {
        this.id = id;
        this.puntaje = puntaje;
        this.comentario = comentario;
        this.idTicket = idTicket;
        this.proyectoEmpresa = proyectoEmpresa;
        this.proyectoCodigo = proyectoCodigo;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getProyectoEmpresa() {
        return proyectoEmpresa;
    }

    public void setProyectoEmpresa(Integer proyectoEmpresa) {
        this.proyectoEmpresa = proyectoEmpresa;
    }

    public Integer getProyectoCodigo() {
        return proyectoCodigo;
    }

    public void setProyectoCodigo(Integer proyectoCodigo) {
        this.proyectoCodigo = proyectoCodigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
