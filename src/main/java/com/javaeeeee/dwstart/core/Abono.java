package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Abono {
    private int codigo;
    private String nombre;
    private String nombreAbreviado;
    private String fechaInicio;
    private String fechaFinal;
    private String profesionalVenta;
    private String lider;
    private Integer estado;
    private String estadoDescripcion;
    private String clase;
    private List<EtapaAbono> etapas;

    public static final int CANCELADO=0;
    public static final int ABIERTO=1;
    public static final int DESARROLLO=2;
    public static final int TESTING_OPEN=3;
    public static final int TESTING_CLIENTE=4;
    public static final int OK_CONSULTOR=5;
    public static final int OK_CLIENTE=6;
    public static final int PRODUCCION=7;
    public static final int CERRADO=8;
    public static final int CIERRE_ENVIADO=9;
    public static final int CIERRE_FORMAL=10;
    public static final int CADUCO=11;

    public Abono() {
    }

    public Abono(int codigo, String nombre, String fechaInicio, String fechaFinal, String lider, String estadoDescripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.lider = lider;
        this.estadoDescripcion = estadoDescripcion;
    }

    public Abono(int codigo, String nombre, String nombreAbreviado, String fechaInicio, String fechaFinal, String profesionalVenta, String lider, Integer estado, String estadoDescripcion, String clase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreAbreviado = nombreAbreviado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.profesionalVenta = profesionalVenta;
        this.lider = lider;
        this.estado = estado;
        this.estadoDescripcion = estadoDescripcion;
        this.clase = clase;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAbreviado() {
        return nombreAbreviado;
    }

    public void setNombreAbreviado(String nombreAbreviado) {
        this.nombreAbreviado = nombreAbreviado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getProfesionalVenta() {
        return profesionalVenta;
    }

    public void setProfesionalVenta(String profesionalVenta) {
        this.profesionalVenta = profesionalVenta;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public List<EtapaAbono> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<EtapaAbono> etapas) {
        this.etapas = etapas;
    }
}
