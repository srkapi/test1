package com.example.demo.application.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class Personaje {

    private Character marca;

    private String nombre;

    private Integer turno;

    private Integer salaSalida;

}
