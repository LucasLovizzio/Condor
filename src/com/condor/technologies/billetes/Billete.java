package com.condor.technologies.billetes;

public class Billete {

    private final int valor;
    private int cantidad;

    public Billete(int valor, int cantidad) {
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
