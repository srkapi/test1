package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.mapper.MapperPersistence;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.adapter.out.persistence.repository.PersonajeRepository;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.out.DeletePersonajePort;
import com.example.demo.application.port.out.FindAllPersonajesPort;
import com.example.demo.application.port.out.FindByMarcaPersonajePort;
import com.example.demo.application.port.out.PersistencePersonajePort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonajePersistenceAdapter implements PersistencePersonajePort, FindAllPersonajesPort, DeletePersonajePort, FindByMarcaPersonajePort {
        final static Logger logger = Logger.getLogger(PersonajeController.class);

        private final PersonajeRepository personajeRepository;
        private final MapperPersistence mapperPersistence;

        @Override
        public Personaje findByMarca(Character marca){
                PersonajeModel personajeModel = this.personajeRepository.findByMarca(marca);
                return this.mapperPersistence.toDomain(personajeModel);
        }

        @Override
        public Personaje save(Personaje personaje){
                PersonajeModel personajeModel =this.mapperPersistence.toModelPersistence(personaje);
                PersonajeModel savedPersonaje = this.personajeRepository.save(personajeModel);
                return this.mapperPersistence.toDomain(savedPersonaje);
        }

        @Override
        public Iterable<Personaje> findAllPersonajes(){

                Iterable<PersonajeModel> list = this.personajeRepository.findAll();

                return this.mapperPersistence.toDomainList(list);
        }

        @Override
        public void deletePersonaje(Character marca){
                this.personajeRepository.delete(personajeRepository.findByMarca(marca));
        }

}
