package com.example.demo.adapter.in.web;

import com.example.demo.application.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendEmailController {
    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping(value = "/sendmail")
    public ResponseEntity<String> sendmail() {

        emailService.sendSimpleMessage("test@example.com", "Test Subject 2", "Test mail 2");

        return new ResponseEntity<String>("emailsent",HttpStatus.OK);
    }
}
