package com.example.demo.application.domain;


public class Personaje {

    private Character marca;

    private String nombre;

    private Integer turno;

    private Integer salaSalida;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getMarca() {
        return marca;
    }

    public void setMarca(char marca) {
        this.marca = marca;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public Integer getSalaSalida() {
        return salaSalida;
    }

    public void setSalaSalida(Integer salaSalida) {
        this.salaSalida = salaSalida;
    }
}
