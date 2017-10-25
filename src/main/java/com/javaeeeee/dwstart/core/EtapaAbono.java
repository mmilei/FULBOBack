package com.javaeeeee.dwstart.core;

/**
 * Created by open0159 on 17/05/2017.
 */
public class EtapaAbono {
    //private int codigo;
    //private int codigoAbono;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinal;
    private double horas;
    private double horasEjecutadas;

    public EtapaAbono() {
    }


    public EtapaAbono(String descripcion, String fechaInicio,
                      String fechaFinal, double horas, double horasEjecutadas) {
        //this.codigo = codigo;
        //this.codigoAbono = codigoAbono;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horas = horas;
        this.horasEjecutadas = horasEjecutadas;
    }


    /*
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoAbono() {
        return codigoAbono;
    }

    public void setCodigoAbono(int codigoAbono) {
        this.codigoAbono = codigoAbono;
    }
    */
    public String getDescripcion() { return descripcion; }

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
