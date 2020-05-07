package com.example.demo.application.port.out;

import com.example.demo.application.domain.Key;

import java.util.List;

public interface FindKeyByIdPersonajePort {
        List<Key> findKeyByIdPersonaje(Long id);
}
