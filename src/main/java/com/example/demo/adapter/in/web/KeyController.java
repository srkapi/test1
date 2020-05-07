package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.CreateKeyCommand;
import com.example.demo.application.port.in.model.ResponseCreateKey;
import com.example.demo.application.port.in.model.ResponseFindKeyByIdPersonaje;
import com.example.demo.application.port.in.usecases.CreateKeyUseCases;
import com.example.demo.application.port.in.usecases.FindKeyByIdPersonajeUseCases;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/key")
public class KeyController {
    final static Logger logger = Logger.getLogger(KeyController.class);
    private final CreateKeyUseCases createKeyUseCases;
    private final FindKeyByIdPersonajeUseCases findKeyByIdPersonajeUseCases;

    @PostMapping
    public ResponseEntity<ResponseCreateKey> addPersonaje(@RequestBody CreateKeyCommand createKeyCommand) {
        ResponseCreateKey result = this.createKeyUseCases.addKey(createKeyCommand);
        return new ResponseEntity<ResponseCreateKey>(result, OK);
    }

    @GetMapping("/idp/{idpersonaje}")
    public ResponseEntity<ResponseFindKeyByIdPersonaje> getKeyByIdPersonaje(@PathVariable("idpersonaje") Long id) {
        ResponseFindKeyByIdPersonaje result = this.findKeyByIdPersonajeUseCases.getKeyByIdPersonaje(id);
        return new ResponseEntity<ResponseFindKeyByIdPersonaje>(result, OK);
    }
}
