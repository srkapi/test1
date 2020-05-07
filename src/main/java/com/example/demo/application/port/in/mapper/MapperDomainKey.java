package com.example.demo.application.port.in.mapper;

import com.example.demo.application.domain.Key;
import com.example.demo.application.port.in.model.CreateKeyCommand;
import com.example.demo.application.port.in.model.ResponseCreateKey;
import com.example.demo.application.port.in.model.ResponseFindKeyByIdPersonaje;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public ResponseFindKeyByIdPersonaje toResponseList(List<Key> key) {
        return ResponseFindKeyByIdPersonaje.builder().responseKeyList(key).build();
    }
}
