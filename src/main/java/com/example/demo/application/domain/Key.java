package com.example.demo.application.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Key {
    private Long code;
    private String name;
    private Long idPersonaje;
}
