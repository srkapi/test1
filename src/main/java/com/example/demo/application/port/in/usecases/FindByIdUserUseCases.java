package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.ResponseFindByIdUser;

public interface FindByIdUserUseCases {
    ResponseFindByIdUser getById(Long id);
}
