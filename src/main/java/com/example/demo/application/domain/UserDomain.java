package com.example.demo.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    //private Collection<Authority> authorities;
    private List<String> authorities;

    public void addAuthority(String authority) {
        if (this.authorities == null) {
            this.authorities = new ArrayList();
        }
        this.authorities.add(authority);
    }
}
