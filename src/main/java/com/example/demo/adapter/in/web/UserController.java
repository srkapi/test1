package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.*;
import com.example.demo.application.port.in.usecases.*;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CreateUserUseCases createUserUseCases;


    @PostMapping
    public ResponseEntity<ResponseCreateUser> addUser(@RequestBody CreateUserCommand createUserCommand) {

        ResponseCreateUser result = this.createUserUseCases.addUser(createUserCommand);

        return new ResponseEntity<ResponseCreateUser>(result, OK);
    }


}
