package com.example.demo.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/activeaccount")
    public ResponseEntity<String> activeAccountByTokenEmail(){
        //activar el usuario del token

        return new ResponseEntity<String>("Account activate", HttpStatus.OK);
    }
}
