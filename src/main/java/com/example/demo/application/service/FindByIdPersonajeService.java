package com.example.demo.application.service;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.usecases.FindByIdPersonajeUseCases;
import com.example.demo.application.port.out.FindByIdPersonajePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindByIdPersonajeService implements FindByIdPersonajeUseCases {
    private final FindByIdPersonajePort findByIdPersonajePort;
    private final MapperDomain mapperDomain;

    @Override
    public ResponseCreatePersonaje getById(Long id){
        Personaje personaje = this.findByIdPersonajePort.findById(id);
        return this.mapperDomain.toResponse(personaje);
    }
}
