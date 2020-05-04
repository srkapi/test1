package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.model.ResponseFindAllPersonajes;
import com.example.demo.application.port.in.usecases.CreatePersonajeUseCases;
import com.example.demo.application.port.in.usecases.FindAllPersonajesUseCases;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
@RequestMapping("/personaje")
public class PersonajeController {
    final static Logger logger = Logger.getLogger(PersonajeController.class);

    private final CreatePersonajeUseCases createPersonajeUseCases;
    private final FindAllPersonajesUseCases findAllPersonajesUseCases;

   @PostMapping
   public ResponseEntity<ResponseCreatePersonaje> addPersonaje(@RequestBody CreatePersonajeCommand createPersonajeCommand){
       //logger.info("personaje "+createPersonajeCommand);
        ResponseCreatePersonaje result =this.createPersonajeUseCases.addPersonaje(createPersonajeCommand);

       return new ResponseEntity<ResponseCreatePersonaje>(result, OK);
   }

    @GetMapping
    public ResponseEntity<Iterable<ResponseFindAllPersonajes>> getAllPersonajes() {
        logger.info("get all personaje ");
        Iterable<ResponseFindAllPersonajes> list = this.findAllPersonajesUseCases.getAllPersonajes();
        logger.info("lista "+list);
        return new ResponseEntity<Iterable<ResponseFindAllPersonajes>>(list, OK);
    }
}
