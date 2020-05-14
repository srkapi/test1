package com.example.demo.application.domain;

import com.example.demo.adapter.out.persistence.model.security.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDomain {
    private Long id;

    private String username;

    private String password;
    private Boolean enabled;

    private Collection<Authority> authorities;

    public void addAuthority(Authority authority) {
        if (this.authorities == null) {
            this.authorities = new ArrayList();
        }
        this.authorities.add(authority);
    }
}
