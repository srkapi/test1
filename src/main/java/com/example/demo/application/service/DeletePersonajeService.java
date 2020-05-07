package com.example.demo.application.service;

import com.example.demo.application.port.in.usecases.DeletePersonajeUseCases;
import com.example.demo.application.port.out.DeletePersonajePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePersonajeService implements DeletePersonajeUseCases {
        private final DeletePersonajePort deletePersonajePort;

    @Override
    public void deletePersonaje(Character marca) {
        this.deletePersonajePort.deletePersonaje(marca);
    }
}
