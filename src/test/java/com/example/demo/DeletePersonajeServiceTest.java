package com.example.demo;

import com.example.demo.application.port.out.DeletePersonajePort;
import com.example.demo.application.service.DeletePersonajeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeletePersonajeServiceTest {
    @Mock
    private DeletePersonajePort deletePersonajePort;

    @InjectMocks
    @Spy
    private DeletePersonajeService deletePersonajeService;

    @Test
    public void givenMarcaWhenCallDeletePersonajeThenReturnNothing() {
        //given
        doNothing().when(deletePersonajePort).deletePersonaje(anyChar());
        //when
        deletePersonajeService.deletePersonaje(anyChar());
        //then
        verify(deletePersonajePort, times(1)).deletePersonaje(anyChar());

    }
}
