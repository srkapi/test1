package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;

public interface CreateUserUseCases {
    ResponseCreateUser addUser(CreateUserCommand createUserCommand);

    void sendMail(ResponseCreateUser responseCreateUser);
}
