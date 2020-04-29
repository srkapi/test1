package com.example.demo;

import com.example.demo.application.domain.Personaje;
import com.example.demo.adapter.out.persistence.repository.PersonajeRepository;
import com.example.demo.application.service.PersonajeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PersonajeServiceTests {
    @Mock
    private PersonajeRepository personajeRepositoryMock;
    @Mock
    private Personaje personajeMock;
    @Mock
    private List<Personaje> list = new ArrayList<>();
    @InjectMocks
    private PersonajeService classTest;

    @Test
    public void probarGetAllPersonajes(){
        Mockito.doReturn(list).when(personajeRepositoryMock).findAll();
        classTest.getAllPersonajes();
        Mockito.verify(personajeRepositoryMock).findAll();
    }

    @Test
    public void probarGetPersonajeByMarca(){

        Mockito.doReturn(this.personajeMock).when(personajeRepositoryMock).findByMarca('E');
        classTest.getPersonajeByMarca('E');
        Mockito.verify(personajeRepositoryMock).findByMarca('E');
    }

    @Test
    public void probarAddPersonaje(){
        Mockito.doReturn(personajeMock).when(personajeRepositoryMock).save(personajeMock);
        classTest.addPersonaje(personajeMock);
        Mockito.verify(personajeRepositoryMock).save(this.personajeMock);
    }

    @Test
    public void probarDeletePersonaje(){
        Mockito.doReturn(personajeMock).when(personajeRepositoryMock).findByMarca('E');
        Mockito.doNothing().when(personajeRepositoryMock).delete(personajeMock);
        classTest.deletePersonaje('E');
        Mockito.verify(personajeRepositoryMock).delete(personajeMock);
    }
}
