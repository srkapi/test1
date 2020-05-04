package com.example.demo.application.port.out;

import com.example.demo.application.domain.Personaje;

/**
 * Interfaz de acceso a persistencia
 * */
public interface PersistencePersonajePort {
        Personaje save(Personaje personaje);
}
