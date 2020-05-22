package com.example.demo.application.port.out;

import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.port.in.model.CreateUserCommand;

/**
 * Interfaz de acceso a persistencia
 */
public interface PersistenceUserPort {
        UserDomain save(UserDomain user, CreateUserCommand createUserCommand);
}
