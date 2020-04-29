package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.application.domain.Personaje;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MapperPersistence {
    //pasa de modelo de dominio a modelo de bbdd
    public PersonajeModel toModelPersistence(Personaje domain){
        return PersonajeModel.builder()
                .nombre(domain.getNombre())
                .turno(domain.getTurno())
                .salaSalida(domain.getSalaSalida())
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public Optional toDomain(PersonajeModel model){
        if (model !=null){
            Personaje build = Personaje.builder().marca(model.getMarca())
                    .nombre(model.getNombre())
                    .turno(model.getTurno())
                    .salaSalida(model.getSalaSalida())
                    .build();
            return Optional.of(build);
        }else{
            return Optional.empty();
        }

    }
}
