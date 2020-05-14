package com.example.demo.application.port.in.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * modelo de request
 **/

@Builder
@Data
public class CreateUserCommand implements Serializable {

    private String username;

    private String password;

    private List<Long> rol;

    private Boolean enabled;
}
