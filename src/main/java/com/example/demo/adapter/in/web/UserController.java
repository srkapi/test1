package com.example.demo.adapter.in.web;

import com.example.demo.adapter.out.service.adapter.SendMailVerificationPort;
import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.model.ResponseFindByIdUser;
import com.example.demo.application.port.in.usecases.CreateUserUseCases;
import com.example.demo.application.port.in.usecases.FindByIdUserUseCases;
import com.example.demo.application.port.in.usecases.ActivateUserUseCases;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
public class UserController {
    final static Logger logger = Logger.getLogger(UserController.class);
    private final CreateUserUseCases createUserUseCases;
    private final FindByIdUserUseCases findByIdUserUseCases;
    private final ActivateUserUseCases activateUserUseCases;



    @PostMapping("/user")
    public ResponseEntity<ResponseCreateUser> addUser(@RequestBody CreateUserCommand createUserCommand) {

        ResponseCreateUser responseCreateUser = this.createUserUseCases.addUser(createUserCommand);
        return new ResponseEntity<ResponseCreateUser>(responseCreateUser, OK);
    }

    @GetMapping("/activeaccount")
    public ResponseEntity<String> activeAccountByTokenEmail(@RequestParam("iduser") Long id) {
        ResponseCreateUser responseCreateUser = this.activateUserUseCases.activateUser(id);
        return new ResponseEntity<String>("Account activate", HttpStatus.OK);
    }
}
