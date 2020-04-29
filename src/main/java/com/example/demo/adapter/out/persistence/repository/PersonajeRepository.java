package com.example.demo.repository;

import com.example.demo.application.domain.Personaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Character> {
    Personaje findByMarca(Character marca);

}
