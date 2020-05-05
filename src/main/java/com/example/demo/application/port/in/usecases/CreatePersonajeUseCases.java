package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;

/**
 * Intefaz de cada caso de uso
 * el método recibe por parámetro los modelos de request y devuelve el modelo response
 */
public interface CreatePersonajeUseCases {
    ResponseCreatePersonaje addPersonaje(CreatePersonajeCommand createPersonajeCommand);
}
