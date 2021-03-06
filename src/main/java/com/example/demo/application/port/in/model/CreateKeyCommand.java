package com.example.demo.application.port.in.model;

import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.application.domain.Personaje;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CreateKeyCommand implements Serializable {
    private String name;
    private Personaje personaje;
}
