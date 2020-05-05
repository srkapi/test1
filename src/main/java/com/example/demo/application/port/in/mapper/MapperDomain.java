package com.example.demo.application.port.in.mapper;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.model.ResponseFindAllPersonajes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Mapper de modelos de request y response a modelos de dominio (y viceversa)
 */
@Component
public class MapperDomain {
    public Personaje toDomain(CreatePersonajeCommand createPersonajeCommand) {
        return Personaje.builder().marca(createPersonajeCommand.getMarca())
                .nombre(createPersonajeCommand.getNombre())
                .turno(createPersonajeCommand.getTurno())
                .salaSalida(createPersonajeCommand.getSalaSalida())
                .build();
    }

    public ResponseCreatePersonaje toResponse(Personaje personaje) {
        return ResponseCreatePersonaje.builder()
                .marca(personaje.getMarca())
                .nombre(personaje.getNombre())
                .turno(personaje.getTurno())
                .salaSalida(personaje.getSalaSalida())
                .build();
    }

    public ResponseFindAllPersonajes toResponseList(List<Personaje> personaje) {
        //List<ResponseFindAllPersonajes> personajesResponse = new ArrayList<>();
        return ResponseFindAllPersonajes.builder().responsePersonajeList(personaje).build();
        /*for (Personaje p : personaje) {
            personajesResponse.add(ResponseFindAllPersonajes.builder()
                    .marca(p.getMarca())
                    .nombre(p.getNombre())
                    .turno(p.getTurno())
                    .salaSalida(p.getSalaSalida())
                    .build());
        }*/
       // return personajesResponse;
    }
}
