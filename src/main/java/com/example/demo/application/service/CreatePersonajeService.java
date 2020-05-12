package com.example.demo.application.service;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.exception.ErrorPersistenceException;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.usecases.CreatePersonajeUseCases;
import com.example.demo.application.port.out.PersistencePersonajePort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implementa cada caso de uso de la entidad. Cada caso de uso convierte el modelo de entrada al de dominio, valida las reglas de dominio y opera con él.
 **/
@Service
@RequiredArgsConstructor
public class CreatePersonajeService implements CreatePersonajeUseCases {
    final static Logger logger = Logger.getLogger(PersonajeController.class);
    private final PersistencePersonajePort persistencePersonajePort;
    private final MapperDomain mapperDomain;

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('PERSONAJE_CREATE')")
    public ResponseCreatePersonaje addPersonaje(CreatePersonajeCommand createPersonajeCommand){
       // logger.info("en servicio "+createPersonajeCommand);
        Personaje personajeDomain = mapperDomain.toDomain(createPersonajeCommand);
        Personaje personaje = this.persistencePersonajePort.save(personajeDomain);
        return this.mapperDomain.toResponse(personaje);
    }
}
