package com.example.demo.adapter.out.service.adapter;

import com.example.demo.application.domain.UserDomain;
import com.example.demo.application.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendMailVerificationAdapter implements SendMailVerificationPort {
    final static Logger logger = Logger.getLogger(CreateUserService.class);
    private final  EmailService emailService;

    @Override
    @Async
    public void sendMail(UserDomain userDomain) {
        emailService.sendSimpleMessage("test@example.com", "Activate user account",
                "Please click on the below link to activate your account. http://localhost:8080/activeaccount?iduser=" + userDomain.getId());
    }
}
