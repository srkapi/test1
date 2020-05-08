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
        return KeyModel.builder()
                .name(domain.getName())
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public Key toDomain(KeyModel model) {
        return Key.builder()
                .name(model.getName())
                .build();
    }
    public List<Key> toDomainList(List<KeyModel> modelList) {

        List<Key> keys = new ArrayList<>();

        for (KeyModel model : modelList) {
            keys.add(Key.builder()
                    .code(model.getCode())
                    .name(model.getName())
                    .build());
        }
        return keys;
    }
}
