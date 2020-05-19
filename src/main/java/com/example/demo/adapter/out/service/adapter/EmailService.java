package com.example.demo.adapter.out.service.adapter;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    public JavaMailSender emailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.emailSender = javaMailSender;
    }


    public void sendSimpleMessage(
            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("pricila@example.com");
        emailSender.send(message);
    }

}
