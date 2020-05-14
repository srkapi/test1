package com.example.demo.application.port.out;

import com.example.demo.application.domain.UserDomain;

/**
 * Interfaz de acceso a persistencia
 */
public interface PersistenceUserPort {
        UserDomain save(UserDomain user);
}
