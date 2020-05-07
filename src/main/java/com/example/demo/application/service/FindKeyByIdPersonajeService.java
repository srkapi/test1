package com.example.demo.application.service;

import com.example.demo.application.domain.Key;
import com.example.demo.application.port.in.mapper.MapperDomainKey;
import com.example.demo.application.port.in.model.ResponseFindKeyByIdPersonaje;
import com.example.demo.application.port.in.usecases.FindKeyByIdPersonajeUseCases;
import com.example.demo.application.port.out.FindKeyByIdPersonajePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindKeyByIdPersonajeService implements FindKeyByIdPersonajeUseCases {
    private final FindKeyByIdPersonajePort findKeyByIdPersonajePort;
    private final MapperDomainKey mapperDomain;

    @Override
    public ResponseFindKeyByIdPersonaje getKeyByIdPersonaje(Long id) {
        List<Key> key = this.findKeyByIdPersonajePort.findKeyByIdPersonaje(id);

        return this.mapperDomain.toResponseList(key);

    }

}
