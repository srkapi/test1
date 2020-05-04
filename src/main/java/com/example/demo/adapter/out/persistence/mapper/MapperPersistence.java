package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.application.domain.Personaje;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * MapperPersistence es un mapper de modelo de dominio a modelo de BBDD
 * */
@Component
public class MapperPersistence {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

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
           return Personaje.builder()
                    .marca(model.getMarca())
                    .nombre(model.getNombre())
                    .turno(model.getTurno())
                    .salaSalida(model.getSalaSalida())
                    .build();
    }

    /**
     * PARA LA LISTA DE PERSONAJES SE HACE UN MÉTODO A PARTE??
     * */
    public Iterable<Personaje> toDomainList(Iterable<PersonajeModel> modelList){

        ArrayList<Personaje> personajes = new ArrayList<>();

        for(PersonajeModel model : modelList)
        {
            //logger.info("to domain list "+model.getNombre());
           personajes.add(Personaje.builder()
                   .marca(model.getMarca())
                   .nombre(model.getNombre())
                   .turno(model.getTurno())
                   .salaSalida(model.getSalaSalida())
                   .build());
        }

        return personajes;
    }
}
