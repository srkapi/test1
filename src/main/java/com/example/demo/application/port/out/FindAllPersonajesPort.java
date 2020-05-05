package com.example.demo.application.port.out;

import com.example.demo.adapter.out.persistence.model.PersonajeModel;
import com.example.demo.application.domain.Personaje;

import java.util.List;

/**
 * Interfaz de acceso a persistencia
 * */
public interface FindAllPersonajesPort {
    List<Personaje> findAllPersonajes();
}
