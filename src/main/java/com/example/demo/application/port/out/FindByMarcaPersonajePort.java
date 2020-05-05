package com.example.demo.application.port.out;

import com.example.demo.application.domain.Personaje;

public interface FindByMarcaPersonajePort {
    Personaje findByMarca(Character marca);
}
