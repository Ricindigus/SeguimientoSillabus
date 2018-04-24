package com.example.dmorales.seguimientosillabus.pojos;

/**
 * Created by dmorales on 23/04/2018.
 */

public class Curso {
    private String escuela;
    private String ciclo;
    private String nombre;
    private String grupo;



    public Curso(String escuela, String ciclo, String nombre, String grupo) {
        this.escuela = escuela;
        this.ciclo = ciclo;
        this.nombre = nombre;
        this.grupo = grupo;

    }



    public Curso() {
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
