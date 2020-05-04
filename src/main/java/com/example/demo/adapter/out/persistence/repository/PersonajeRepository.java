package com.example.demo.adapter.out.persistence.repository;


import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PersonajeRepository accede a la BBDD y extiende CrudRepository para hacer las operaciones CRUD en la misma
 * */
@Repository
public interface PersonajeRepository extends CrudRepository<PersonajeModel, Character> {

    PersonajeModel findByMarca(Character marca);

}
