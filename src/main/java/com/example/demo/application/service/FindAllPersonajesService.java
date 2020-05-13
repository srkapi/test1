package com.example.demo.application.service;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.ResponseFindAllPersonajes;
import com.example.demo.application.port.in.usecases.FindAllPersonajesUseCases;
import com.example.demo.application.port.out.FindAllPersonajesPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllPersonajesService implements FindAllPersonajesUseCases {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

    private final FindAllPersonajesPort findAllPersonajesPort;
    private final MapperDomain mapperDomain;

    @Override
    @Transactional(readOnly = true) //el readonly dependerá de la bbdd
    @PreAuthorize("hasAuthority('PERSONAJE_READ')")
    public ResponseFindAllPersonajes getAllPersonajes() {
        //logger.info("get all personajes in service");
        List<Personaje> personaje = this.findAllPersonajesPort.findAllPersonajes();

        return this.mapperDomain.toResponseList(personaje);
    }
}
