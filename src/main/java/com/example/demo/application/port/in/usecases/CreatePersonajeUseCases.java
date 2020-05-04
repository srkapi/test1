package com.example.demo.application.port.in.usecases;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;

/**
 * Intefaz de cada caso de uso
 * */
public interface CreatePersonajeUseCases {
    ResponseCreatePersonaje addPersonaje(CreatePersonajeCommand createPersonajeCommand);
}
