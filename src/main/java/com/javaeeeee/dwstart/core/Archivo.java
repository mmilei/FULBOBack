package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Archivo {
    private int idTicket;
    private int idRenglon;
    private String nombre;
    private String extension;
    private String datosBase64;

    @JsonIgnore
    private byte[] datosBlob;

    public Archivo(int idTicket, int idRenglon, String nombre, String extension, byte[] datosBlob) {
        this.idTicket = idTicket;
        this.idRenglon = idRenglon;
        this.nombre = nombre;
        this.extension = extension;
        this.datosBlob = datosBlob;
    }

    public Archivo(int idTicket, int idRenglon, String nombre, String extension, String datosBase64) {
        this.idTicket = idTicket;
        this.idRenglon = idRenglon;
        this.nombre = nombre;
        this.extension = extension;
        this.datosBase64 = datosBase64;
    }


    public Archivo(){super();}

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdRenglon() {
        return idRenglon;
    }

    public void setIdRenglon(int idRenglon) {
        this.idRenglon = idRenglon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getdatosBase64() {
        return datosBase64;
    }

    public void setdatosBase64(String datosBase64) {
        this.datosBase64 = datosBase64;
    }

    public byte[] getDatosBlob() {
        return datosBlob;
    }

    public void setDatosBlob(byte[] datosBlob) {
        this.datosBlob = datosBlob;
    }
}

