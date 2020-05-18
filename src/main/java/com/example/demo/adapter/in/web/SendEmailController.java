package com.example.demo.adapter.in.web;

import com.example.demo.application.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendEmailController {
    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping(value = "/sendmail")
    public ResponseEntity<String> sendmail(@RequestParam String token) {

        emailService.sendSimpleMessage("test@example.com", "Test activate user account",
                "Please click on the below link to activate your account. http://localhost:8080/activeaccount?token=" + token);

        return new ResponseEntity<String>("Email sent successfully", HttpStatus.OK);
    }
}
