package com.example.dmorales.seguimientosillabus.pojos;

/**
 * Created by dmorales on 24/04/2018.
 */

public class Actividad {
    String descripcion;

    public Actividad(String descripcion) {
        this.descripcion = descripcion;
    }

    public Actividad() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
