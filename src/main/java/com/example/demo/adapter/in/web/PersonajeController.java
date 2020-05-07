package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.model.ResponseFindAllPersonajes;
import com.example.demo.application.port.in.usecases.*;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/personaje")
public class PersonajeController {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

    private final CreatePersonajeUseCases createPersonajeUseCases;
    private final FindAllPersonajesUseCases findAllPersonajesUseCases;
    private final DeletePersonajeUseCases deletePersonajeUseCases;
    private final FindByMarcaPersonajeUseCases findByMarcaPersonajeUseCases;
    private final UpdatePersonajeUseCases updatePersonajeUseCases;
    private final FindByIdPersonajeUseCases findByIdPersonajeUseCases;

    @GetMapping("/{marca}")
    public ResponseEntity<ResponseCreatePersonaje> getByMarca(@PathVariable("marca") Character marca) {
        ResponseCreatePersonaje result = this.findByMarcaPersonajeUseCases.getByMarca(marca);
        if(marca!=null)
            return new ResponseEntity<ResponseCreatePersonaje>(result, OK);
        else
            return new ResponseEntity<ResponseCreatePersonaje>(result, NOT_FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseCreatePersonaje> getById(@PathVariable("id") Long id) {
        ResponseCreatePersonaje result = this.findByIdPersonajeUseCases.getById(id);
        if(id!=null)
            return new ResponseEntity<ResponseCreatePersonaje>(result, OK);
        else
            return new ResponseEntity<ResponseCreatePersonaje>(result, NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ResponseCreatePersonaje> addPersonaje(@RequestBody CreatePersonajeCommand createPersonajeCommand) {
        ResponseCreatePersonaje result = this.createPersonajeUseCases.addPersonaje(createPersonajeCommand);

        return new ResponseEntity<ResponseCreatePersonaje>(result, OK);
    }

    @GetMapping
    public ResponseEntity<ResponseFindAllPersonajes> getAllPersonajes() {
        ResponseFindAllPersonajes list = this.findAllPersonajesUseCases.getAllPersonajes();
        return new ResponseEntity<ResponseFindAllPersonajes>(list, OK);
    }

    @DeleteMapping("/{marca}")
    public ResponseEntity<Void> deletePersonaje(@PathVariable("marca") Character marca) {
        this.deletePersonajeUseCases.deletePersonaje(marca);
        return new ResponseEntity<Void>(NO_CONTENT); //204 NO CONTENT = La petición se ha completado con éxito pero su respuesta no tiene ningún contenido. Los encabezados pueden ser útiles
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCreatePersonaje> updatePersonaje(@RequestBody CreatePersonajeCommand createPersonajeCommand, @PathVariable("id") Long id) {
        ResponseCreatePersonaje result = this.updatePersonajeUseCases.updatePersonaje(createPersonajeCommand, id);
        return new ResponseEntity<ResponseCreatePersonaje>(result, OK);
    }
}
