package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.ResponseCreatePersonaje;

public interface FindByIdPersonajeUseCases {
    ResponseCreatePersonaje getById(Long id);
}
