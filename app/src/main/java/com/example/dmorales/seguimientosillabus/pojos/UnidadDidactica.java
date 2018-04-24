package com.example.dmorales.seguimientosillabus.pojos;

/**
 * Created by dmorales on 23/04/2018.
 */

public class UnidadDidactica {
    private int numero;
    private String nombre;

    public UnidadDidactica(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public UnidadDidactica() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
