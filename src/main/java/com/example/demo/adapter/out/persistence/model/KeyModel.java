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
@Table(name = "llaves")
public class KeyModel {
    @Id
    @GeneratedValue
    private Long code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional =false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_personaje", nullable = false)
    private PersonajeModel personajeModel;
}
