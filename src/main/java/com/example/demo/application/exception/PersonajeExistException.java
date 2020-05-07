package com.example.demo.application.exception;

public class PersonajeExistException extends RuntimeException{
    public PersonajeExistException(String msg){
        super(msg);
    }
}
