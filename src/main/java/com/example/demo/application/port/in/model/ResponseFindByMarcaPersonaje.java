package com.example.demo.application.port.in.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseFindByMarcaPersonaje {
    private Character marca;

    private String nombre;

    private Integer turno;

    private Integer salaSalida;
}
