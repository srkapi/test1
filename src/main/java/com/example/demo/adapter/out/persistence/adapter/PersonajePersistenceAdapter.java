package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.out.persistence.mapper.MapperPersistence;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.adapter.out.persistence.repository.PersonajeRepository;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.out.PersistencePersonajePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class PersonajePersistenceAdapter implements PersistencePersonajePort {
        private final PersonajeRepository personajeRepository;
        private final MapperPersistence mapperPersistence;

        @Override
        public Personaje save(Personaje personaje){
                PersonajeModel personajeModel =this.mapperPersistence.toModelPersistence(personaje);
                PersonajeModel savedPersonaje = this.personajeRepository.save(personajeModel);
                return this.mapperPersistence.toDomain(savedPersonaje);
        }

}
