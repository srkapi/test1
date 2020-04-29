package com.example.demo.schedule;

import com.example.demo.application.domain.Personaje;
import com.example.demo.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class PersonajeSchedule {
    final static Logger logger = Logger.getLogger(PersonajeSchedule.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private IPersonajeService servicioPersonaje;

    //fixedRate: la tarea se ejecuta cada x segundos
    //FixedDelay: la tarea espera a que se termine de ejecutar la tarea anterior
    //${miRatioInsertarP} = coge el ratio del application.properties

    @Scheduled(fixedRateString = "${miRatioInsertarP}")
    public void insertarPersonajeSchedule(){

        logger.info("Inserta el personaje cada 1 minuto "+ dateTimeFormatter.format(LocalDateTime.now()));
        Personaje personaje=new  Personaje();
        personaje.setMarca('A');
        personaje.setNombre("Arya");
        personaje.setTurno(2);
        personaje.setSalaSalida(20);
        servicioPersonaje.addPersonaje(personaje);
    }

}
