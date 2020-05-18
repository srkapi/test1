package com.example.demo.application.service;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.mapper.MapperDomainUser;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.usecases.CreateUserUseCases;
import com.example.demo.application.port.out.PersistenceUserPort;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;


/**
 * Implementa cada caso de uso de la entidad. Cada caso de uso convierte el modelo de entrada al de dominio, valida las reglas de dominio y opera con él.
 **/
@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCases {
    final static Logger logger = Logger.getLogger(CreateUserService.class);
    private final AuthorityRepository authorityRepository;
    private final PersistenceUserPort persistenceUserPort;
    private final MapperDomainUser mapperDomain;
    private MailSender mailSender;

    @Autowired
    private EmailServiceImpl emailService;

    @Override
    public ResponseCreateUser addUser(CreateUserCommand createUserCommand) {
        UserDomain userDomain = mapperDomain.toDomain(createUserCommand);
        List<Long> roles = createUserCommand.getRol();
        for (Long rol : roles) {
            Authority authority = this.authorityRepository.findById(rol).orElseThrow(() -> new EntityNotFoundException());
            userDomain.addAuthority(authority);
        }
        UserDomain user = this.persistenceUserPort.save(userDomain);
        Collection<Authority> authorities = this.authorityRepository.findAuthorityByIdUser(user.getId());
        user.setAuthorities(authorities);
        return this.mapperDomain.toResponse(user);
    }

    @Override
    @Async
    public void sendMail(ResponseCreateUser responseCreateUser) {
        emailService.sendSimpleMessage("test@example.com", "Test activate user account",
                "Please click on the below link to activate your account. http://localhost:8080/activeaccount?iduser=" + responseCreateUser.getId());
    }
}
