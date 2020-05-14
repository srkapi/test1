package com.example.demo.application.port.in.model;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

/**
 * modelo de response
 * */
@Builder
@Data
public class ResponseCreateUser implements Serializable {

    private String username;

    private String password;

    private Collection<Authority> authorities;
}
