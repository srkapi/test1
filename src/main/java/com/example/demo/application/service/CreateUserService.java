package com.example.demo.application.service;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.adapter.out.service.adapter.SendMailVerificationPort;
import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.mapper.MapperDomainUser;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.usecases.CreateUserUseCases;
import com.example.demo.application.port.out.PersistenceUserPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Implementa cada caso de uso de la entidad. Cada caso de uso convierte el modelo de entrada al de dominio, valida las reglas de dominio y opera con él.
 **/
@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCases {
    final static Logger logger = Logger.getLogger(CreateUserService.class);
    private final AuthorityRepository authorityRepository;
    private final PersistenceUserPort persistenceUserPort;
    private final SendMailVerificationPort sendMailVerificationPort;
    private final MapperDomainUser mapperDomain;


    @Override
    public ResponseCreateUser addUser(CreateUserCommand createUserCommand) {
        UserDomain userDomain = mapperDomain.toDomain(createUserCommand);

        UserDomain user = this.persistenceUserPort.save(userDomain, createUserCommand);

        this.sendMailVerificationPort.sendMail(user);
        return this.mapperDomain.toResponse(user);

    }
}
