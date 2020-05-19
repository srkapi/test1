package com.example.demo.application.port.out;

import com.example.demo.application.domain.UserDomain;

public interface ActivateUserPort {
    UserDomain activateUser(UserDomain userDomain, Long id);
}
