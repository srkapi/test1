package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.model.ResponseFindByIdUser;

public interface UpdateUserUseCases {
        ResponseCreateUser updateUser(ResponseFindByIdUser responseFindByIdUser, Long id);
}
