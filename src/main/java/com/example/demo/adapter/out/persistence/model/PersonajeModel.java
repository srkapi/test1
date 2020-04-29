package com.example.demo.adapter.out.persistence.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="personajes")
public class PersonajeModel {

    @Id
    @Column(name = "marca", nullable = false)
    private Character marca;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "turno", nullable = false)
    private Integer turno;

    @Column(name = "salaSalida", nullable = false)
    private Integer salaSalida;
}
