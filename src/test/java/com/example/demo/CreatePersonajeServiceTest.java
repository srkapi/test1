package com.example.demo;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.CreatePersonajeCommand;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.out.PersistencePersonajePort;
import com.example.demo.application.service.CreatePersonajeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreatePersonajeServiceTest {

    @Mock
    private PersistencePersonajePort persistencePersonajePort;
    @Mock
    private MapperDomain mapperDomain;

    @InjectMocks
    @Spy
    private CreatePersonajeService createPersonajeService;

    @Test
    public void givenCreatePersonajeCommandWhenCallAddPersonajeThenReturnResponseCreatePersonaje() {
        //given
        Personaje personaje = mock(Personaje.class);
        CreatePersonajeCommand createPersonajeCommand = mock(CreatePersonajeCommand.class);
        ResponseCreatePersonaje responseCreatePersonaje = mock(ResponseCreatePersonaje.class);
        doReturn(personaje).when(mapperDomain).toDomain(createPersonajeCommand);
        doReturn(personaje).when(persistencePersonajePort).save(personaje);
        doReturn(responseCreatePersonaje).when(mapperDomain).toResponse(personaje);
        //when
        ResponseCreatePersonaje serviceResponse = createPersonajeService.addPersonaje(createPersonajeCommand);
        //then
        assertNotNull(serviceResponse);
        assertEquals(responseCreatePersonaje, serviceResponse);
        verify(mapperDomain, times(1)).toDomain(createPersonajeCommand);
        verify(persistencePersonajePort, times(1)).save(personaje);

    }
}
