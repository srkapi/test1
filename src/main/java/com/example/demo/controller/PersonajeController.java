package com.example.demo.controller;

import com.example.demo.Personaje;
import com.example.demo.service.IPersonajeService;
import com.example.demo.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api")
public class PersonajeController {
    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("personaje/{marca}")
    public ResponseEntity<Personaje> getPersonajeByMarca(@PathVariable("marca") Character marca) {
        Personaje article = personajeService.getPersonajeByMarca(marca);
        return new ResponseEntity<Personaje>(article, HttpStatus.OK);
    }

    @GetMapping("personaje")
    @ResponseBody
    public ResponseEntity<List<Personaje>> getAllPersonajes() {
        List<Personaje> list = personajeService.getAllPersonajes();
        return new ResponseEntity<List<Personaje>>(list, HttpStatus.OK);
    }

    @PostMapping("personaje")
    public ResponseEntity<Void> addPersonaje(@RequestBody Personaje personaje, UriComponentsBuilder builder) {
        boolean flag = personajeService.addPersonaje(personaje);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/personaje/{marca}").buildAndExpand(personaje.getMarca()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("personaje/{marca}")
    public ResponseEntity<Personaje> updatePersonaje(@RequestBody Personaje personaje, @PathVariable("marca") Character marca) {
        personaje.setMarca(marca);
        personajeService.updatePersonaje(personaje);
        return new ResponseEntity<Personaje>(personaje, HttpStatus.OK);
    }

    @DeleteMapping("personaje/{marca}")
    public ResponseEntity<Void> deletePersonaje(@PathVariable("marca") Character marca) {
        personajeService.deletePersonaje(marca);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
