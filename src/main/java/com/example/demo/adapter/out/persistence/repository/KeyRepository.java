package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.model.KeyModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KeyRepository extends CrudRepository<KeyModel, Long> {

    @Query(value = "select k.code,k.name,k.id_personaje from llaves k  where k.id_personaje = :idP", nativeQuery = true)
    List<KeyModel> findKeyByIdPersonaje(@Param("idP") Long id);
}
