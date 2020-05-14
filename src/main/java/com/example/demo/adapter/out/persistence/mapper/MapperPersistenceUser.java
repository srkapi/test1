package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.model.KeyModel;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.adapter.out.persistence.model.security.Authority;
import com.example.demo.adapter.out.persistence.model.security.User;
import com.example.demo.adapter.out.persistence.repository.AuthorityRepository;
import com.example.demo.adapter.out.persistence.repository.KeyRepository;
import com.example.demo.application.domain.Key;
import com.example.demo.application.domain.Personaje;
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
    private final AuthorityRepository authorityRepository;

    //pasa de modelo de dominio a modelo de bbdd
    public User toModelPersistence(UserDomain domain) {
        Collection<Authority> authorities = this.authorityRepository.findAuthorityByIdUser(domain.getId());

        return User.builder()
                .username(domain.getUsername())
                .password(domain.getPassword())
                .enabled(domain.getEnabled())
                .authorities(domain.getAuthorities())
                .build();
    }

    //pasa de modelo de bbdd a modelo de dominio
    public UserDomain toDomain(User model) {

        return UserDomain.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .authorities(model.getAuthorities())
                .build();
    }


}
