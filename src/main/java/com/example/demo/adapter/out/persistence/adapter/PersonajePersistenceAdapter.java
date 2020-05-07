package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.mapper.MapperPersistence;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.adapter.out.persistence.repository.PersonajeRepository;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.out.*;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonajePersistenceAdapter implements PersistencePersonajePort, FindAllPersonajesPort, DeletePersonajePort,
        FindByMarcaPersonajePort, UpdatePersonajePort, FindByIdPersonajePort {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

    private final PersonajeRepository personajeRepository;
    private final MapperPersistence mapperPersistence;

    @Override
    public Personaje findByMarca(Character marca) {
        PersonajeModel personajeModel = this.personajeRepository.findByMarca(marca);
        return this.mapperPersistence.toDomain(personajeModel);
    }

    @Override
    public Personaje findById(Long id) {
        Optional<PersonajeModel> personaje = this.personajeRepository.findById(id);
        PersonajeModel personajeModel = personaje.get();
        return this.mapperPersistence.toDomain(personajeModel);
    }

    @Override
    public Personaje save(Personaje personaje) {
        PersonajeModel personajeModel = this.mapperPersistence.toModelPersistence(personaje);
        PersonajeModel savedPersonaje = this.personajeRepository.save(personajeModel);
        return this.mapperPersistence.toDomain(savedPersonaje);
    }

    @Override
    public List<Personaje> findAllPersonajes() {

        List<PersonajeModel> list = this.personajeRepository.findAll();

        return this.mapperPersistence.toDomainList(list);
    }

    @Override
    public void deletePersonaje(Character marca) {
        this.personajeRepository.delete(personajeRepository.findByMarca(marca));
    }

    @Override
    public Personaje update(Personaje personaje, Long id) {
        PersonajeModel personajeModel = this.mapperPersistence.toModelPersistence(personaje);
        personajeModel.setId(id);
        PersonajeModel savedPersonaje = this.personajeRepository.save(personajeModel);
        return this.mapperPersistence.toDomain(savedPersonaje);
    }


}
