package com.example.demo.application.domain;

import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Key {
    private Long code;
    private String name;
    private Personaje personaje;
}
