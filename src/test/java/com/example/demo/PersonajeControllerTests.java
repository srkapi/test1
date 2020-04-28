package com.example.demo;

import com.example.demo.controller.PersonajeController;
import com.example.demo.service.IPersonajeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PersonajeControllerTests {
    @Mock
    private IPersonajeService personajeService;
    @Mock
    private Personaje personajeMock;
    @Mock
    private List<Personaje> list = new ArrayList<>();
    @InjectMocks
    private PersonajeController classTest;
    private UriComponentsBuilder builder;


    @Test
    public void probarGetPersonajeByMarca(){
        Mockito.doReturn(personajeMock).when(personajeService).getPersonajeByMarca('E');
        ResponseEntity<Personaje> httpResponse = classTest.getPersonajeByMarca('E');

        Mockito.verify(personajeService).getPersonajeByMarca('E');
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void probarGetAllPersonajes(){
        Mockito.doReturn(list).when(personajeService).getAllPersonajes();
        ResponseEntity<List<Personaje>> httpResponse =  classTest.getAllPersonajes();

        Mockito.verify(personajeService).getAllPersonajes();
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void probarAddPersonaje(){
        Mockito.doReturn(true).when(personajeService).addPersonaje(personajeMock);
        ResponseEntity<Void> httpResponse =  classTest.addPersonaje(personajeMock, builder);

        Mockito.verify(personajeService).addPersonaje(personajeMock);
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void probarUpdatePersonaje(){
        Mockito.doNothing().when(personajeService).updatePersonaje(personajeMock);
        ResponseEntity<Personaje> httpResponse =  classTest.updatePersonaje(personajeMock, 'E');

        Mockito.verify(personajeService).updatePersonaje(personajeMock);
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void probarDeletePersonaje(){
        Mockito.doNothing().when(personajeService).deletePersonaje('E');
        ResponseEntity<Void> httpResponse =  classTest.deletePersonaje('E');

        Mockito.verify(personajeService).deletePersonaje('E');
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
