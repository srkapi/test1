package com.example.demo.application.service;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.usecases.UpdatePersonajeUseCases;
import com.example.demo.application.port.out.UpdatePersonajePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatePersonajeService implements UpdatePersonajeUseCases {
    private final UpdatePersonajePort updatePersonajePort;
    private final MapperDomain mapperDomain;

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('PERSONAJE_UPDATE')")
    public ResponseCreatePersonaje updatePersonaje(CreatePersonajeCommand createPersonajeCommand, Long id){
        Personaje personajeDomain = mapperDomain.toDomain(createPersonajeCommand);
        Personaje personaje = this.updatePersonajePort.update(personajeDomain, id);
        return this.mapperDomain.toResponse(personaje);
    }
}
