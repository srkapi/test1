package com.example.demo.application.port.in.model;

import com.example.demo.application.domain.Personaje;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class ResponseFindAllPersonajes implements Serializable {

    private List<Personaje> responsePersonajeList;

}
