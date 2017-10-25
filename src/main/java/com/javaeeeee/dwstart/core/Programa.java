package com.javaeeeee.dwstart.core;

public class Programa {
    private int id;
    private String modulo;
    private String ubicacion;
    private String nombre;
    private String descripcionCambio;

    public Programa(int id, String modulo, String ubicacion, String nombre, String descripcionCambio) {
        this.id = id;
        this.modulo = modulo;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.descripcionCambio = descripcionCambio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionCambio() {
        return descripcionCambio;
    }

    public void setDescripcionCambio(String descripcionCambio) {
        this.descripcionCambio = descripcionCambio;
    }
}
