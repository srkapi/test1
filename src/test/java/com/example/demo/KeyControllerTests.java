package com.example.demo;

import com.example.demo.adapter.out.persistence.model.KeyModel;
import com.example.demo.adapter.out.persistence.repository.KeyRepository;
import com.example.demo.application.domain.Key;
import com.example.demo.application.port.in.model.ResponseFindKeyByIdPersonaje;
import com.example.demo.application.port.out.FindKeyByIdPersonajePort;
import com.example.demo.application.service.FindKeyByIdPersonajeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(KeyController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KeyControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindKeyByIdPersonajeService findKeyByIdPersonajeService;

    @MockBean
    private FindKeyByIdPersonajePort findKeyByIdPersonajePort;

    @MockBean
    private KeyRepository keyRepository;

    @MockBean
    private List<Key> keyList;
    @MockBean
    private List<KeyModel> keyModelList;
    @MockBean
    private ResponseFindKeyByIdPersonaje responseFindKeyByIdPersonaje;

    @Test
    public void returnMessageOkWhenFindkeyByIdPersonaje() throws Exception {
        int idPersonaje = 2;
        Long idPersonajeToLong = Long.valueOf(idPersonaje);
        when(findKeyByIdPersonajeService.getKeyByIdPersonaje(idPersonajeToLong)).thenReturn(responseFindKeyByIdPersonaje);
        this.mockMvc.perform(get("/key/idp/")).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"responseKeyList\": [\n" +
                        "        {\n" +
                        "            \"code\": 5,\n" +
                        "            \"name\": \"llave3\",\n" +
                        "            \"personajeModel\": {\n" +
                        "                \"id\": 2,\n" +
                        "                \"marca\": \"A\",\n" +
                        "                \"nombre\": \"Arya\",\n" +
                        "                \"turno\": 1,\n" +
                        "                \"salaSalida\": 4\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }
}
