package com.example.dmorales.seguimientosillabus.pojos;

import java.util.ArrayList;

/**
 * Created by dmorales on 24/04/2018.
 */

public class Semana {
    int numero;
    int unidad;
    String tema;
    ArrayList<Actividad> actividades;

    public Semana(int numero, int unidad, String tema, ArrayList<Actividad> actividades) {
        this.numero = numero;
        this.unidad = unidad;
        this.tema = tema;
        this.actividades = actividades;
    }

    public Semana() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
}
