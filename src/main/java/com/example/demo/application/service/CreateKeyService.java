package com.example.demo.application.service;

import com.example.demo.application.domain.Key;
import com.example.demo.application.port.in.mapper.MapperDomainKey;
import com.example.demo.application.port.in.model.CreateKeyCommand;
import com.example.demo.application.port.in.model.ResponseCreateKey;
import com.example.demo.application.port.in.usecases.CreateKeyUseCases;
import com.example.demo.application.port.out.CreateKeyPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateKeyService implements CreateKeyUseCases {
    final static Logger logger = Logger.getLogger(CreateKeyService.class);

    private final CreateKeyPort createKeyPort;
    private final MapperDomainKey mapperDomain;

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('KEY_CREATE')")
    public ResponseCreateKey addKey(CreateKeyCommand createKeyCommand) {
        Key keyDomain = mapperDomain.toDomain(createKeyCommand);
        Key key = this.createKeyPort.save(keyDomain);
        return this.mapperDomain.toResponse(key);
    }
}
