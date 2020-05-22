package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.ResponseFindKeyByIdPersonaje;

public interface FindKeyByIdPersonajeUseCases {
    ResponseFindKeyByIdPersonaje getKeyByIdPersonaje(Long id);
}
