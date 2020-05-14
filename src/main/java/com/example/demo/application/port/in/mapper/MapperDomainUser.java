package com.example.demo.application.port.in.mapper;

import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;


/**
 * Mapper de modelos de request y response a modelos de dominio (y viceversa)
 */
@Component
@RequiredArgsConstructor
public class MapperDomainUser {
    final static Logger logger = Logger.getLogger(MapperDomainUser.class);

    public UserDomain toDomain(CreateUserCommand createUserCommand) {
        //hash password BCrypt
        String passwordEncrypted = BCrypt.hashpw(createUserCommand.getPassword(), BCrypt.gensalt());

        return UserDomain.builder().username(createUserCommand.getUsername())
                .password(passwordEncrypted)
                .enabled(createUserCommand.getEnabled())
                .build();
    }

    public ResponseCreateUser toResponse(UserDomain user) {
        return ResponseCreateUser.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .build();
    }

}
