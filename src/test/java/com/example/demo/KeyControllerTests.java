package com.example.demo;

import com.example.demo.adapter.in.web.KeyController;
import com.example.demo.application.port.in.model.ResponseFindKeyByIdPersonaje;
import com.example.demo.application.port.in.usecases.FindKeyByIdPersonajeUseCases;
import com.example.demo.application.service.FindKeyByIdPersonajeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(KeyController.class)
public class KeyControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindKeyByIdPersonajeService findKeyByIdPersonajeService;

    @MockBean
    private ResponseFindKeyByIdPersonaje responseFindKeyByIdPersonaje;

    @Test
    public void returnMessageFindkeyByIdPersonaje() throws Exception{
        int i=2;
        Long lo = Long.valueOf(i);
        when(findKeyByIdPersonajeService.getKeyByIdPersonaje(lo)).thenReturn(responseFindKeyByIdPersonaje);
        this.mockMvc.perform(get("/key/idp")).andExpect(status().isOk())
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
