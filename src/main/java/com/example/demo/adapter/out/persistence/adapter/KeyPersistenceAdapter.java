package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.mapper.MapperPersistenceKey;
import com.example.demo.adapter.out.persistence.model.KeyModel;
import com.example.demo.adapter.out.persistence.repository.KeyRepository;
import com.example.demo.application.domain.Key;
import com.example.demo.application.port.out.CreateKeyPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyPersistenceAdapter implements CreateKeyPort {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

    private final KeyRepository keyRepository;
    private final MapperPersistenceKey mapperPersistence;


    @Override
    public Key save(Key key) {
        KeyModel keyModel = this.mapperPersistence.toModelPersistence(key);
        KeyModel savedKey = this.keyRepository.save(keyModel);
        return this.mapperPersistence.toDomain(savedKey);
    }
}
