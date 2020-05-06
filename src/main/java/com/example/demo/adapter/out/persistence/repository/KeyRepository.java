package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.model.KeyModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends CrudRepository<KeyModel, Long> {

}
