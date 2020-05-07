package com.example.demo.application.port.in.model;

import com.example.demo.application.domain.Key;
import com.example.demo.application.domain.Personaje;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ResponseFindKeyByIdPersonaje {
    private List<Key> responseKeyList;
}
