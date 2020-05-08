package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.model.KeyModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KeyRepository extends CrudRepository<KeyModel, Long> {

    @Query(value = "select llaves.code,llaves.name,llaves.id_personaje,personajes.nombre from llaves inner join  personajes on llaves.id_personaje =personajes.id and personajes.id= :idP", nativeQuery = true)
    List<KeyModel> findKeyByIdPersonaje(@Param("idP") Long id);
}
