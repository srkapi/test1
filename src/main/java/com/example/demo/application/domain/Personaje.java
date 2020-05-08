package com.example.demo.application.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Personaje {
    private Long id;
    private Character marca;

    private String nombre;

    private Integer turno;

    private Integer salaSalida;

    private List<Key> keyList;

}
