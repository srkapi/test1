package com.example.demo;

import com.example.demo.schedule.PersonajeSchedule;
import com.example.demo.service.IPersonajeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//Con la anotación @RunWith JUnit invoca la clase MockitoJUnitRunner.class para inicializar los simulacros y lanzar los tests
//con la anotación @Mock, Mockito se encarga de crear un mock (objeto simulado) de cada objeto anotado
//con la anotación @InjectMocks, crea una instancia de la clase e inyecta las simulaciones creadas con @Mock
//con la notación @Test, indica que el método ejecuta pruebas
@RunWith(MockitoJUnitRunner.class)
public class PersonajeScheduleTests {
    @Mock
    private IPersonajeService servicioPersonaje;

    @Mock
    private Personaje personaje;

    @InjectMocks
    private PersonajeSchedule classTest;

    @Test
    public void probarInsertarPersonajeSchedule(){

       Mockito.doReturn(personaje).when(servicioPersonaje).addPersonaje(personaje);
        classTest.insertarPersonajeSchedule();
        Mockito.verify(servicioPersonaje).addPersonaje(personaje);
    }
}
