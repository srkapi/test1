package com.example.demo;

import com.example.demo.adapter.out.service.adapter.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendEmailApplicationTest {
    @Autowired
    private EmailService emailService;

    @Test
    public void testEmail() {
        emailService.sendSimpleMessage("pri@example.com", "Test subject", "Test mail");
    }
}
