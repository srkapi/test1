package com.example.demo;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.usecases.CreatePersonajeUseCases;
import com.example.demo.application.port.in.usecases.FindAllPersonajesUseCases;
import com.example.demo.application.port.in.usecases.FindByIdPersonajeUseCases;
import com.example.demo.application.port.in.usecases.FindByMarcaPersonajeUseCases;
import com.example.demo.application.service.FindByIdPersonajeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersonajeController.class)
//Con esas dos anotaciones da una excepción: java.lang.IllegalStateException: Failed to load ApplicationContext
//@WebMvcTest(PersonajeController.class) //con esa anotación da NUllPointerException
@Import(PersonajeControllerTests.Config.class)
public class PersonajeControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private FindByIdPersonajeService findByIdPersonajeService;
    @Autowired
    private PersonajeController personajeController;
    @MockBean
    private ResponseCreatePersonaje responseCreatePersonaje;
    @MockBean
    private FindByIdPersonajeUseCases findByIdPersonajeUseCases;
    @MockBean
    private CreatePersonajeUseCases createPersonajeUseCases;
    @MockBean
    private FindByMarcaPersonajeUseCases findByMarcaPersonajeUseCases;
    @MockBean
    private FindAllPersonajesUseCases findAllPersonajesUseCases;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(personajeController)
                .build();
    }

    @Test
    public void returnMessageOkWhenFindByIdPersonaje() throws Exception {
        int idPersonaje = 2;
        Long idPersonajeToLong = Long.valueOf(idPersonaje);
        when(findByIdPersonajeUseCases.getById(idPersonajeToLong)).thenReturn(responseCreatePersonaje);
        this.mockMvc.perform(get("/personaje/id/2")).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"marca\": \"C\",\n" +
                        "    \"nombre\": \"Cersei\",\n" +
                        "    \"turno\": 1,\n" +
                        "    \"salaSalida\": 4\n" +
                        "}"));
    }

    @Test
    public void shouldReturn404WhenPersonajeNotFound() throws Exception {
        int idPersonaje = 5;
        Long idPersonajeToLong = Long.valueOf(idPersonaje);
        when(findByIdPersonajeUseCases.getById(idPersonajeToLong)).thenReturn(null);
        mockMvc.perform(get("/personaje/id/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @TestConfiguration
    protected static class Config {

        @Bean
        public FindByIdPersonajeService findByIdPersonajeService() {
            return Mockito.mock(FindByIdPersonajeService.class);
        }

    }
}
