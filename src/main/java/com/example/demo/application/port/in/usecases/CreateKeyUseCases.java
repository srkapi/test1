package com.example.demo.application.port.in.usecases;

import com.example.demo.application.port.in.model.CreateKeyCommand;
import com.example.demo.application.port.in.model.ResponseCreateKey;

public interface CreateKeyUseCases {
    ResponseCreateKey addKey(CreateKeyCommand createKeyCommand);
}
