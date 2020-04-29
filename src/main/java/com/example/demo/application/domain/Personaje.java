package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="personajes")
public class Personaje implements Serializable {

    @Id
    @Column(name = "marca", nullable = false)
    private Character marca;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "turno", nullable = false)
    private Integer turno;

    @Column(name = "salaSalida", nullable = false)
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
