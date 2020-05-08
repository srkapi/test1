package com.example.demo.adapter.out.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca", nullable = false)
    private Character marca;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "turno", nullable = false)
    private Integer turno;

    @Column(name = "salaSalida", nullable = false)
    private Integer salaSalida;

    @OneToMany(mappedBy = "personajeModel")
    private List<KeyModel> keyList;
}
