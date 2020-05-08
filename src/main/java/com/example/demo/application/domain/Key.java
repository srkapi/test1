package com.example.demo.application.domain;

import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Key {
    private Long code;
    private String name;
    private Personaje personaje;
}
