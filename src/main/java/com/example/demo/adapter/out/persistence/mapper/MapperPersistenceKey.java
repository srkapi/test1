package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.model.KeyModel;
import com.example.demo.application.domain.Key;
import org.springframework.stereotype.Component;

@Component
public class MapperPersistenceKey {
    public KeyModel toModelPersistence(Key domain) {
        return KeyModel.builder()
                .name(domain.getName())
                .personajeModel(domain.getPersonajeModel())
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public Key toDomain(KeyModel model) {
        return Key.builder()
                .name(model.getName())
                .personajeModel(model.getPersonajeModel())
                .build();
    }
}
