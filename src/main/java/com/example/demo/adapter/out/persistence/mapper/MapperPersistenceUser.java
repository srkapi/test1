package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.model.security.User;
import com.example.demo.application.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * MapperPersistence es un mapper de modelo de dominio a modelo de BBDD
 */
@Component
@RequiredArgsConstructor
public class MapperPersistenceUser {
    final static Logger logger = Logger.getLogger(MapperPersistenceUser.class);

    //pasa de modelo de dominio a modelo de bbdd
    public User toModelPersistence(UserDomain domain, Collection authorityCollection) {
        return User.builder()
                .username(domain.getUsername())
                .password(domain.getPassword())
                .authorities(authorityCollection)
                .build();
    }

    public User toModelPersistenceActivate(UserDomain domain, Collection authorityCollection) {
        return User.builder()
                .username(domain.getUsername())
                .password(domain.getPassword())
                .enabled(domain.getEnabled())
                .authorities(authorityCollection)
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public UserDomain toDomain(User model) {
        Collection<Authority> authoritiesCollection = model.getAuthorities();
        List<String> authoritiesStrings = new ArrayList<>();
        for (Authority authorities : authoritiesCollection) {
            authoritiesStrings.add(authorities.getName());
        }
        return UserDomain.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .enabled(model.isEnabled())
                .authorities(authoritiesStrings)
                .build();
    }
}
