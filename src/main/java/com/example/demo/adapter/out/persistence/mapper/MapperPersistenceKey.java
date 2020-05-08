package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.model.KeyModel;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.application.domain.Key;
import com.example.demo.application.domain.Personaje;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperPersistenceKey {

    public KeyModel toModelPersistence(Key domain) {
        PersonajeModel personajeModel = new PersonajeModel();
        personajeModel.setId(domain.getPersonaje().getId());
        return KeyModel.builder()
                .name(domain.getName())
                .personajeModel(personajeModel)
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public Key toDomain(KeyModel model) {
        Personaje personaje = new Personaje();
        personaje.setId(model.getPersonajeModel().getId());
        return Key.builder()
                .name(model.getName())
                .personaje(personaje)
                .build();
    }
    public List<Key> toDomainList(List<KeyModel> modelList) {

        List<Key> keys = new ArrayList<>();
        Personaje personaje = new Personaje();

        for (KeyModel model : modelList) {
            personaje.setId(model.getPersonajeModel().getId());
            keys.add(Key.builder()
                    .code(model.getCode())
                    .name(model.getName())
                    .personaje(personaje)
                    .build());
        }
        return keys;
    }
}
