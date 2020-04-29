package com.example.demo.adapter.in.web;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.usecases.IPersonajeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("api")
public class PersonajeController {
    final static Logger logger = Logger.getLogger(PersonajeController.class);
    @Autowired
    private IPersonajeService servicioPersonaje;


    @GetMapping("personaje/{marca}")
    public ResponseEntity<Personaje> getPersonajeByMarca(@PathVariable("marca") Character marca) throws Exception{
        Personaje personaje = servicioPersonaje.getPersonajeByMarca(marca);
        if(personaje == null){
            throw new NoSuchElementException("Personaje not found");
        }
        return new ResponseEntity<Personaje>(personaje, HttpStatus.OK); //200 OK GET = el recurso se ha obtenido y se transmite en el cuerpo del mensaje
    }

    @GetMapping("personaje")
    @ResponseBody
    public ResponseEntity<List<Personaje>> getAllPersonajes() {
        List<Personaje> list = servicioPersonaje.getAllPersonajes();
        return new ResponseEntity<List<Personaje>>(list, HttpStatus.OK);
    }

    @PostMapping("personaje")
    public ResponseEntity<Void> addPersonaje(@RequestBody Personaje personaje, UriComponentsBuilder builder) throws Exception {
        boolean insertP = servicioPersonaje.addPersonaje(personaje);
        //insertP=false;
        if (insertP == false) {
            //return new ResponseEntity<Void>(HttpStatus.CONFLICT); //409 CONFLICT = respuesta enviada cuando una petición tiene conflicto con el estado actual del servidor
            throw new Exception("Insert personaje failed");
        }
       // HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(builder.path("/personaje/{marca}").buildAndExpand(personaje.getMarca()).toUri());
        return new ResponseEntity<Void>(HttpStatus.CREATED); //201 CREATED = La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello
    }

    @PutMapping("personaje/{marca}")
    public ResponseEntity<Personaje> updatePersonaje(@RequestBody Personaje personaje, @PathVariable("marca") Character marca) {
        personaje.setMarca(marca);
        servicioPersonaje.updatePersonaje(personaje);
        return new ResponseEntity<Personaje>(personaje, HttpStatus.OK);
    }

    @DeleteMapping("personaje/{marca}")
    public ResponseEntity<Void> deletePersonaje(@PathVariable("marca") Character marca) {
        servicioPersonaje.deletePersonaje(marca);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //204 NO CONTENT = La petición se ha completado con éxito pero su respuesta no tiene ningún contenido. Los encabezados pueden ser útiles
    }

}
