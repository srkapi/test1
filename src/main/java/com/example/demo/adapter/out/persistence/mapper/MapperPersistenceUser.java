package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.model.security.User;
import com.example.demo.application.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


/**
 * MapperPersistence es un mapper de modelo de dominio a modelo de BBDD
 */
@Component
@RequiredArgsConstructor
public class MapperPersistenceUser {
    final static Logger logger = Logger.getLogger(MapperPersistenceUser.class);

    //pasa de modelo de dominio a modelo de bbdd
    public User toModelPersistence(UserDomain domain) {
        return User.builder()
                .username(domain.getUsername())
                .password(domain.getPassword())
                .authorities(domain.getAuthorities())
                .build();
    }
    public User toModelPersistenceUpdate(UserDomain domain) {
        return User.builder()
                .password(domain.getPassword())
                .enabled(domain.getEnabled())
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public UserDomain toDomain(User model) {

        return UserDomain.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .enabled(model.isEnabled())
                .authorities(model.getAuthorities())
                .build();
    }
    public UserDomain toDomainUpdate(User model) {

        return UserDomain.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .enabled(model.isEnabled())
                .build();
    }
}
