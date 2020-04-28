package com.example.demo.repository;

import com.example.demo.Personaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Character> {
    Personaje findByMarca(Character marca);

}
