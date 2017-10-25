package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDetalle {
    @JsonIgnore
    private Integer id;
    private Integer renglon;
    private Integer consultor;
    private String consultorDescripcion;
    private String tareaRealizada;
    private String fechaEntrada;
    private String fechaSalida;
    private Integer estado;

    public TicketDetalle(Integer id, Integer renglon, Integer consultor, String consultorDescripcion, String tareaRealizada, String fechaEntrada, String fechaSalida, Integer estado) {
        this.id = id;
        this.renglon = renglon;
        this.consultor = consultor;
        this.consultorDescripcion = consultorDescripcion;
        this.tareaRealizada = tareaRealizada;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRenglon() {
        return renglon;
    }

    public void setRenglon(Integer renglon) {
        this.renglon = renglon;
    }

    public Integer getConsultor() {
        return consultor;
    }

    public void setConsultor(Integer consultor) {
        this.consultor = consultor;
    }

    public String getTareaRealizada() {
        return tareaRealizada;
    }

    public void setTareaRealizada(String tareaRealizada) {
        this.tareaRealizada = tareaRealizada;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getConsultorDescripcion() {
        return consultorDescripcion;
    }

    public void setConsultorDescripcion(String consultorDescripcion) {
        this.consultorDescripcion = consultorDescripcion;
    }
}
