package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.model.CreateUserCommand;
import com.example.demo.application.port.in.model.ResponseCreateUser;
import com.example.demo.application.port.in.model.ResponseFindByIdUser;
import com.example.demo.application.port.in.usecases.CreateUserUseCases;
import com.example.demo.application.port.in.usecases.FindByIdUserUseCases;
import com.example.demo.application.port.in.usecases.UpdateUserUseCases;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
//@RequestMapping
public class UserController {
    final static Logger logger = Logger.getLogger(UserController.class);
    private final CreateUserUseCases createUserUseCases;
    private final FindByIdUserUseCases findByIdUserUseCases;
    private final UpdateUserUseCases updateUserUseCases;
    private final UserDetailsService userDetailsService;


    @PostMapping("/user")
    public ResponseEntity<ResponseCreateUser> addUser(@RequestBody CreateUserCommand createUserCommand) {

        ResponseCreateUser responseCreateUser = this.createUserUseCases.addUser(createUserCommand);
        this.createUserUseCases.sendMail(responseCreateUser);
        return new ResponseEntity<ResponseCreateUser>(responseCreateUser, OK);
    }

    @GetMapping("/activeaccount")
    public ResponseEntity<String> activeAccountByTokenEmail(@RequestParam("iduser") Long id) {
        ResponseFindByIdUser responseFindByIdUser = this.findByIdUserUseCases.getById(id);
        ResponseCreateUser responseCreateUser = this.updateUserUseCases.updateUser(responseFindByIdUser, id);
        return new ResponseEntity<String>("Account activate", HttpStatus.OK);
    }
}
