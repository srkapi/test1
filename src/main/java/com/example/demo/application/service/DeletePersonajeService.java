package com.example.demo.application.service;

import com.example.demo.application.port.in.usecases.DeletePersonajeUseCases;
import com.example.demo.application.port.out.DeletePersonajePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeletePersonajeService implements DeletePersonajeUseCases {
        private final DeletePersonajePort deletePersonajePort;

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('PERSONAJE_DELETE')")
    public void deletePersonaje(Character marca) {
        this.deletePersonajePort.deletePersonaje(marca);
    }
}
