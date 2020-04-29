package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DemoExceptionHandler {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    //la anotación @ExceptionHandler permite manejar las excepciones a partir de un método dentro de una clase
    //en este caso se maneja las de tipo Exception.
    //el método exceptionHandler maneja las excepciones de tipo Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(HttpServletRequest request, Exception e) {
        ErrorInfo result = new ErrorInfo(dateTimeFormatter.format(LocalDateTime.now()),HttpStatus.CONFLICT.value(),e.getMessage(),request.getRequestURI());
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorInfo> exceptionNoSuchElement(HttpServletRequest request, Exception e) {
        ErrorInfo result = new ErrorInfo(dateTimeFormatter.format(LocalDateTime.now()),HttpStatus.NOT_FOUND.value(),e.getMessage(),request.getRequestURI());
        return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
    }


}
