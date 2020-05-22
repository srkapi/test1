package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.model.KeyModel;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.adapter.out.persistence.repository.KeyRepository;
import com.example.demo.application.domain.Key;
import com.example.demo.application.domain.Personaje;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * MapperPersistence es un mapper de modelo de dominio a modelo de BBDD
 */
@Component
@RequiredArgsConstructor
public class MapperPersistence {
    final static Logger logger = Logger.getLogger(PersonajeController.class);
    private final KeyRepository keyRepository;
    private final MapperPersistenceKey mapperPersistence;

    //pasa de modelo de dominio a modelo de bbdd
    public PersonajeModel toModelPersistence(Personaje domain) {
        return PersonajeModel.builder()
                .marca(domain.getMarca())
                .nombre(domain.getNombre())
                .turno(domain.getTurno())
                .salaSalida(domain.getSalaSalida())
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public Personaje toDomain(PersonajeModel model) {
        return Personaje.builder()
                .marca(model.getMarca())
                .nombre(model.getNombre())
                .turno(model.getTurno())
                .salaSalida(model.getSalaSalida())
                .build();
    }


    public List<Personaje> toDomainList(List<PersonajeModel> modelList) {

        List<Personaje> personajes = new ArrayList<>();
        for (PersonajeModel model : modelList) {
            //ver llaves asignadas al personaje
            List<KeyModel> listKeysModel = this.keyRepository.findKeyByIdPersonaje(model.getId());
            List<Key> listKeys = this.mapperPersistence.toDomainList(listKeysModel);
            personajes.add(Personaje.builder()
                    .id(model.getId())
                    .marca(model.getMarca())
                    .nombre(model.getNombre())
                    .turno(model.getTurno())
                    .salaSalida(model.getSalaSalida())
                    .keyList(listKeys)
                    .build());
        }

        return personajes;
    }
}
