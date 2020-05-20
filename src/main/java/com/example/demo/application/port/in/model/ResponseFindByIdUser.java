package com.example.demo.application.port.in.model;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Builder
@Data
public class ResponseFindByIdUser {
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private List<String> authorities;
}
