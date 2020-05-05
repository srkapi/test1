package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.model.ResponseFindByMarcaPersonaje;

public interface FindByMarcaPersonajeUseCases {
    ResponseCreatePersonaje getByMarca(Character marca);
}
