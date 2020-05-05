package com.example.demo.application.port.out;

import com.example.demo.application.domain.Personaje;

public interface UpdatePersonajePort {
    Personaje update(Personaje personaje, Long id);
}
