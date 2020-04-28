package com.example.demo.configuration;


import com.example.demo.service.IPersonajeService;
import com.example.demo.service.PersonajeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSpring {

    @Bean("servicioPersonaje")
    public IPersonajeService serviceBean(){
        return new PersonajeService();
    }
}
