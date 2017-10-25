package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cliente {
    private int id;
    private String nombre;
    private String nomabre;

    @JsonIgnore
    private int estado;

    public Cliente(int id, String nombre, String nomabre, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.nomabre = nomabre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomabre() {
        return nomabre;
    }

    public void setNomabre(String nomabre) {
        this.nomabre = nomabre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
