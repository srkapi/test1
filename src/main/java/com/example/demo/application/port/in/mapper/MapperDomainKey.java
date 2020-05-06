package com.example.demo.application.port.in.mapper;

import com.example.demo.application.domain.Key;
import com.example.demo.application.port.in.model.CreateKeyCommand;
import com.example.demo.application.port.in.model.ResponseCreateKey;
import org.springframework.stereotype.Component;

@Component
public class MapperDomainKey {
    public Key toDomain(CreateKeyCommand createKeyCommand) {
        return Key.builder().name(createKeyCommand.getName())
                .personajeModel(createKeyCommand.getPersonajeModel())
                .build();
    }

    public ResponseCreateKey toResponse(Key key) {
        return ResponseCreateKey.builder()
                .name(key.getName())
                .personajeModel(key.getPersonajeModel())
                .build();
    }
/*
    public ResponseFindAllPersonajes toResponseList(List<Personaje> personaje) {
        return ResponseFindAllPersonajes.builder().responsePersonajeList(personaje).build();
    }*/
}
