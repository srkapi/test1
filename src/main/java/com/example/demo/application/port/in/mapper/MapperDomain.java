package com.example.demo.application.port.in.mapper;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import org.springframework.stereotype.Component;


/**
 * Mapper de modelos de request y response a modelos de dominio (y viceversa)
 * */
@Component
public class MapperDomain {
    public Personaje toDomain(CreatePersonajeCommand createPersonajeCommand) {
        return Personaje.builder().marca(createPersonajeCommand.getMarca())
                .nombre(createPersonajeCommand.getNombre())
                .turno(createPersonajeCommand.getTurno())
                .salaSalida(createPersonajeCommand.getSalaSalida())
                .build();
    }

    public ResponseCreatePersonaje toResponse(Personaje responsePersistence) {
        return ResponseCreatePersonaje.builder()
                .marca(responsePersistence.getMarca())
                .nombre(responsePersistence.getNombre())
                .turno(responsePersistence.getTurno())
                .salaSalida(responsePersistence.getSalaSalida())
                .build();
    }


}
