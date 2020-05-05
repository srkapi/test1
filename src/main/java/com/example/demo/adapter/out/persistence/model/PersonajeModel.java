package com.example.demo.adapter.out.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Modelo de BBDD
 */
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personajes")
public class PersonajeModel { //Modelo de BBDD

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "marca", nullable = false)
    private Character marca;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "turno", nullable = false)
    private Integer turno;

    @Column(name = "salaSalida", nullable = false)
    private Integer salaSalida;
}
