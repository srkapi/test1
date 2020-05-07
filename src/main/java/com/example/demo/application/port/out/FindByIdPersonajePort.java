package com.example.demo.application.port.out;

import com.example.demo.application.domain.Personaje;

public interface FindByIdPersonajePort {
    Personaje findById(Long id);
}
