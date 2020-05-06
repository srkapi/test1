package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.CreateKeyCommand;
import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreateKey;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.usecases.CreateKeyUseCases;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/key")
public class KeyController {
    final static Logger logger = Logger.getLogger(PersonajeController.class);
    private final CreateKeyUseCases createKeyUseCases;

    @PostMapping
    public ResponseEntity<ResponseCreateKey> addPersonaje(@RequestBody CreateKeyCommand createKeyCommand) {
        ResponseCreateKey result = this.createKeyUseCases.addKey(createKeyCommand);

        return new ResponseEntity<ResponseCreateKey>(result, OK);
    }
}
