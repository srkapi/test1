package com.example.demo.application.service;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.ResponseFindAllPersonajes;
import com.example.demo.application.port.in.usecases.FindAllPersonajesUseCases;
import com.example.demo.application.port.out.FindAllPersonajesPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllPersonajesService implements FindAllPersonajesUseCases {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

    private final FindAllPersonajesPort findAllPersonajesPort;
    private final MapperDomain mapperDomain;

    @Override
    public Iterable<ResponseFindAllPersonajes> getAllPersonajes(){
        logger.info("get all personajes in service");
        Iterable<Personaje> personaje = this.findAllPersonajesPort.findAllPersonajes();
        /**
         * HACER OTRO METODO EN EL MAPPER DOMAIN PARA QUE DEVUELVA UNA LISTA DEL MODELO RESPONSE??
         * */
        return this.mapperDomain.toResponseList(personaje);
    }
}
