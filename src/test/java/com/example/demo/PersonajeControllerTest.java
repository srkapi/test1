package com.example.demo;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.service.FindByIdPersonajeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersonajeController.class})
public class PersonajeControllerTest {
    @Autowired
    private PersonajeController personajeController;
    @Autowired
    private FindByIdPersonajeService findByIdPersonajeService;
    @Autowired
    private Personaje personaje;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(personajeController).build();
    }

    @Test
    public void getPersonajes_null_shouldReturnOk() throws Exception {
        // Given
        Mockito.doReturn(personaje).when(findByIdPersonajeService).getById(anyLong());

        // When
        final ResultActions result = mockMvc.perform(
                get("/personaje")
                        .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // Then
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.name").value(personaje.getNombre()));
        result.andExpect(jsonPath("$[?(@.name === 'Arya')]").exists());
    }

}
