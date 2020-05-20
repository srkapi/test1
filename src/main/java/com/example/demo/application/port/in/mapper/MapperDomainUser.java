package com.example.demo.application.port.in.mapper;

import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.model.ResponseFindByIdUser;
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

        return UserDomain.builder()
                .username(createUserCommand.getUsername())
                .password(passwordEncrypted)
                .build();
    }

    public UserDomain toDomainById(ResponseFindByIdUser responseFindByIdUser) {
        return UserDomain.builder()
                .id(responseFindByIdUser.getId())
                .username(responseFindByIdUser.getUsername())
                .password(responseFindByIdUser.getPassword())
                .enabled(responseFindByIdUser.getEnabled())
                .authorities(responseFindByIdUser.getAuthorities())
                .build();
    }

    public ResponseCreateUser toResponse(UserDomain user) {
        return ResponseCreateUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .build();
    }

    public ResponseFindByIdUser toResponseById(UserDomain user) {
        return ResponseFindByIdUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.getEnabled())
                .authorities(user.getAuthorities())
                .build();
    }
}
