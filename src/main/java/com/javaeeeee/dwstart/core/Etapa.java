package com.javaeeeee.dwstart.core;

/**
 * Created by open0136 on 17/05/2017.
 */
public class Etapa {
    private int codigo;
    private int codigoProyecto;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinal;
    private String nombre;
    private String estado;
    private String clase;
    private double horas;
    private double horasEjecutadas;

    public Etapa() {
    }


    public Etapa(int codigo, int codigoProyecto, String descripcion, String fechaInicio, String fechaFinal, String nombre, String estado, String clase,
                 double horas, double horasEjecutadas) {
        this.codigo = codigo;
        this.codigoProyecto = codigoProyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nombre = nombre;
        this.estado = estado;
        this.clase = clase;
        this.horas = horas;
        this.horasEjecutadas = horasEjecutadas;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getHoras_ejecutadas() {
        return horasEjecutadas;
    }

    public void setClase(double horasEjecutadas) {
        this.horasEjecutadas = horasEjecutadas;
    }
}
