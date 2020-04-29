package com.example.demo.application.service;

import com.example.demo.application.domain.Personaje;
import com.example.demo.adapter.out.persistence.repository.PersonajeRepository;
import com.example.demo.application.port.in.usecases.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> getAllPersonajes() {
        List<Personaje> list = new ArrayList<>();
        personajeRepository.findAll().forEach(e -> list.add((Personaje) e));
        return list;
    }

    @Override
    public Personaje getPersonajeByMarca(Character marca) {
        Personaje obj = personajeRepository.findByMarca(marca);
        return obj;
    }

    @Override
    public boolean addPersonaje(Personaje personaje) {
            personajeRepository.save(personaje);
            return true;
    }

    @Override
    public void updatePersonaje(Personaje personaje) {

        personajeRepository.save(personaje);
    }

    @Override
    public void deletePersonaje(Character marca) {
        personajeRepository.delete(getPersonajeByMarca(marca));
    }

}
