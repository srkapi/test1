package com.example.demo.application.port.in.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * modelo de request
 **/

@Builder
@Data
public class CreateUserCommand implements Serializable {

    private String username;

    private String password;

    private Long rol;

    private Boolean enabled;
}
