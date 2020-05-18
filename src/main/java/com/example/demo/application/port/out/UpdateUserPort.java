package com.example.demo.application.port.out;

import com.example.demo.application.domain.UserDomain;

public interface UpdateUserPort {
    UserDomain update(UserDomain userDomain, Long id);
}
