package com.example.demo.service;

import com.example.demo.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPersonajeService {
    List<Personaje> getAllPersonajes();
    Personaje getPersonajeByMarca(Character marca);
    boolean addPersonaje(Personaje personaje);
    void updatePersonaje(Personaje personaje);
    void deletePersonaje(Character marca);
}
