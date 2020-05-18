package com.example.demo.application.port.out;

import com.example.demo.application.domain.UserDomain;

public interface FindByIdUserPort {
    UserDomain findById(Long id);
}
