package com.example.demo.adapter.out.service.adapter;

import com.example.demo.application.domain.UserDomain;
import org.springframework.scheduling.annotation.Async;

public interface SendMailVerificationPort {

    void sendMail(UserDomain userDomain);
}
