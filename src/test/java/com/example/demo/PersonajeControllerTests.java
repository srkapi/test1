package com.example.demo;

import com.example.demo.adapter.in.web.PersonajeController;
import com.example.demo.adapter.out.persistence.mapper.MapperPersistence;
import com.example.demo.application.domain.Key;
import com.example.demo.application.domain.Personaje;
import com.example.demo.application.port.in.model.ResponseCreatePersonaje;
import com.example.demo.application.port.in.usecases.CreatePersonajeUseCases;
import com.example.demo.application.port.in.usecases.FindAllPersonajesUseCases;
import com.example.demo.application.port.in.usecases.FindByIdPersonajeUseCases;
import com.example.demo.application.port.in.usecases.FindByMarcaPersonajeUseCases;
import com.example.demo.application.service.FindByIdPersonajeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonajeController.class)
public class PersonajeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MapperPersistence objectMapper;

    @MockBean
    private CreatePersonajeUseCases createPersonajeUseCases;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        Key key1 = new Key();
        List<Key> listkeys = new ArrayList<>();
        listkeys.add(key1);
        int idPersonaje = 2;
        Long idPersonajeToLong = Long.valueOf(idPersonaje);
        Personaje personaje = new Personaje(idPersonajeToLong,'E', "Eddad", 1,2,listkeys);
/*
        mockMvc.perform(post("/secured/personaje")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.toModelPersistence(personaje))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());*/
    }
}
