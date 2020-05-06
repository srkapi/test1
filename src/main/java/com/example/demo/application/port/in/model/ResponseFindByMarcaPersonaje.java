package com.example.demo.application.port.in.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ResponseFindByMarcaPersonaje implements Serializable {
    private Character marca;

    private String nombre;

    private Integer turno;

    private Integer salaSalida;
}
