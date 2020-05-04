package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.mapper.MapperPersistence;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.adapter.out.persistence.repository.PersonajeRepository;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.out.FindAllPersonajesPort;
import com.example.demo.application.port.out.PersistencePersonajePort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonajePersistenceAdapter implements PersistencePersonajePort, FindAllPersonajesPort {
        final static Logger logger = Logger.getLogger(PersonajeController.class);

        private final PersonajeRepository personajeRepository;
        private final MapperPersistence mapperPersistence;

        @Override
        public Personaje save(Personaje personaje){
                PersonajeModel personajeModel =this.mapperPersistence.toModelPersistence(personaje);
                PersonajeModel savedPersonaje = this.personajeRepository.save(personajeModel);
                return this.mapperPersistence.toDomain(savedPersonaje);
        }

        @Override
        public Iterable<Personaje> findAllPersonajes(){

                Iterable<PersonajeModel> list = this.personajeRepository.findAll();
                /**
                 * HACER OTRO METODO EN EL MAPPER PERSISTANCE PARA QUE DEVUELVA UNA LISTA DEL MODELO DE DOMINIO??
                 * */
                //logger.info("find all in persistence "+list);
                return this.mapperPersistence.toDomainList(list);
        }

}
