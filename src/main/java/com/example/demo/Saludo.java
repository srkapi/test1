package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludo {
    @GetMapping("/hola")
    public String getHola(){

        return "Hola, ¿que tal?";
    }


}
