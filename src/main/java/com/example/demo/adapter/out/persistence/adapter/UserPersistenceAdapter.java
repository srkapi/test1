package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.mapper.MapperPersistence;
import com.example.demo.adapter.out.persistence.mapper.MapperPersistenceUser;
import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.adapter.out.persistence.model.security.User;
import com.example.demo.adapter.out.persistence.repository.PersonajeRepository;
import com.example.demo.adapter.out.persistence.repository.UserRepository;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.out.*;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements PersistenceUserPort, FindByIdUserPort,UpdateUserPort {
    final static Logger logger = Logger.getLogger(UserPersistenceAdapter.class);

    private final UserRepository userRepository;
    private final MapperPersistenceUser mapperPersistence;


    @Override
    public UserDomain save(UserDomain userDomain) {
        User user = this.mapperPersistence.toModelPersistence(userDomain);
        User savedUser = this.userRepository.save(user);
        return this.mapperPersistence.toDomain(savedUser);
    }

    @Override
    public UserDomain findById(Long id){
        Optional<User> userOptional = this.userRepository.findById(id);
        User user = userOptional.get();
        return this.mapperPersistence.toDomain(user);
    }

    @Override
    public UserDomain update(UserDomain userDomain, Long id){
        User user = this.mapperPersistence.toModelPersistenceUpdate(userDomain);
        user.setId(id);
        User updatedUser = this.userRepository.save(user);
        return this.mapperPersistence.toDomainUpdate(updatedUser);
    }
}
