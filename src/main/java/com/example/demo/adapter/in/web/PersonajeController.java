package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.model.ResponseFindAllPersonajes;
import com.example.demo.application.port.in.usecases.CreatePersonajeUseCases;
import com.example.demo.application.port.in.usecases.DeletePersonajeUseCases;
import com.example.demo.application.port.in.usecases.FindAllPersonajesUseCases;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
@RequestMapping("/personaje")
public class PersonajeController {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

    private final CreatePersonajeUseCases createPersonajeUseCases;
    private final FindAllPersonajesUseCases findAllPersonajesUseCases;
    private final DeletePersonajeUseCases deletePersonajeUseCases;

    @PostMapping
    public ResponseEntity<ResponseCreatePersonaje> addPersonaje(@RequestBody CreatePersonajeCommand createPersonajeCommand) {
        ResponseCreatePersonaje result = this.createPersonajeUseCases.addPersonaje(createPersonajeCommand);

        return new ResponseEntity<ResponseCreatePersonaje>(result, OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<ResponseFindAllPersonajes>> getAllPersonajes() {
        Iterable<ResponseFindAllPersonajes> list = this.findAllPersonajesUseCases.getAllPersonajes();
        return new ResponseEntity<Iterable<ResponseFindAllPersonajes>>(list, OK);
    }

    @DeleteMapping("/{marca}")
    public ResponseEntity<Void> deletePersonaje(@PathVariable("marca") Character marca) {
        this.deletePersonajeUseCases.deletePersonaje(marca);
        return new ResponseEntity<Void>(NO_CONTENT); //204 NO CONTENT = La petición se ha completado con éxito pero su respuesta no tiene ningún contenido. Los encabezados pueden ser útiles
    }
}
