package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.usecases.CreateUserUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CreateUserUseCases createUserUseCases;
    private final UserDetailsService userDetailsService;


    @PostMapping
    public ResponseEntity<ResponseCreateUser> addUser(@RequestBody CreateUserCommand createUserCommand) {

        ResponseCreateUser responseCreateUser = this.createUserUseCases.addUser(createUserCommand);

        return new ResponseEntity<ResponseCreateUser>(responseCreateUser, OK);
    }


}
