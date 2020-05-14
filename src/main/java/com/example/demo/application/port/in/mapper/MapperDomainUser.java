package com.example.demo.application.port.in.mapper;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;


/**
 * Mapper de modelos de request y response a modelos de dominio (y viceversa)
 */
@Component
@RequiredArgsConstructor
public class MapperDomainUser {
    final static Logger logger = Logger.getLogger(MapperDomainUser.class);
    private final AuthorityRepository authorityRepository;

    public UserDomain toDomain(CreateUserCommand createUserCommand) {
        //hash password BCrypt
        String passwordEncrypted = BCrypt.hashpw(createUserCommand.getPassword(), BCrypt.gensalt());

        Authority authority = this.authorityRepository.findById(createUserCommand.getRol()).orElseThrow(() -> new EntityNotFoundException());
        //logger.info("mapper domain find authority by id "+authority);
        UserDomain userDomain = new UserDomain();
        userDomain.addAuthority(authority);
        userDomain.setUsername(createUserCommand.getUsername());
        userDomain.setPassword(passwordEncrypted);
        userDomain.setEnabled(createUserCommand.getEnabled());
        return userDomain;
    }

    public ResponseCreateUser toResponse(UserDomain user) {
        Collection<Authority> authorities = this.authorityRepository.findAuthorityByIdUser(user.getId());
        //logger.info("mapper domain find authority by id "+user.getId());
        return ResponseCreateUser.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }

}
