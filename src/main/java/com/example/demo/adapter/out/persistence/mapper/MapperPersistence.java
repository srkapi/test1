package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.application.domain.Personaje;
import org.springframework.stereotype.Component;


/**
 * MapperPersistence es un mapper de modelo de dominio a modelo de BBDD
 * */
@Component
public class MapperPersistence {
    //pasa de modelo de dominio a modelo de bbdd
    public PersonajeModel toModelPersistence(Personaje domain){
        return PersonajeModel.builder()
                .marca(domain.getMarca())
                .nombre(domain.getNombre())
                .turno(domain.getTurno())
                .salaSalida(domain.getSalaSalida())
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public Personaje toDomain(PersonajeModel model){

           return Personaje.builder().marca(model.getMarca())
                    .marca(model.getMarca())
                    .nombre(model.getNombre())
                    .turno(model.getTurno())
                    .salaSalida(model.getSalaSalida())
                    .build();
    }
}
