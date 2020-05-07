package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;

public interface UpdatePersonajeUseCases {
    ResponseCreatePersonaje updatePersonaje(CreatePersonajeCommand createPersonajeCommand, Long id);
}
