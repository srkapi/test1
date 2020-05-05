package com.example.demo.application.service;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.usecases.FindByMarcaPersonajeUseCases;
import com.example.demo.application.port.out.FindByMarcaPersonajePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindByMarcaPersonajeService implements FindByMarcaPersonajeUseCases {
    private final FindByMarcaPersonajePort findByMarcaPersonajePort;
    private final MapperDomain mapperDomain;


    @Override
    public ResponseCreatePersonaje getByMarca(Character marca) {
        Personaje personaje = this.findByMarcaPersonajePort.findByMarca(marca);
        return this.mapperDomain.toResponse(personaje);
    }
}
