package com.example.demo;

import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.mapper.MapperDomain;
import com.example.demo.application.port.in.model.ResponseFindAllPersonajes;
import com.example.demo.application.port.out.FindAllPersonajesPort;
import com.example.demo.application.service.FindAllPersonajesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FindAllPersonajesServiceTest {

    @Mock
    private FindAllPersonajesPort findAllPersonajesPort;

    @Mock
    private MapperDomain mapperDomain;

    @InjectMocks
    @Spy
    private FindAllPersonajesService findAllPersonajesService;

    @Test
    public void givenNoneWhenCallGetAllPersonajesThenReturnListPersonajes() {
        //given
        Personaje personaje = mock(Personaje.class);
        List<Personaje> personajesList = Arrays.asList(personaje);
        ResponseFindAllPersonajes responseFindAllPersonajes = mock(ResponseFindAllPersonajes.class);
        doReturn(personajesList).when(findAllPersonajesPort).findAllPersonajes();
        doReturn(responseFindAllPersonajes).when(mapperDomain).toResponseList(personajesList);
        //when
        ResponseFindAllPersonajes serviceResponse = findAllPersonajesService.getAllPersonajes();
        //then
        assertNotNull(serviceResponse);
        assertEquals(responseFindAllPersonajes, serviceResponse);
        verify(findAllPersonajesPort, times(1)).findAllPersonajes();
    }

}
