package com.example.notificationservice.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    public static final String ACCOUNT_SID = System.getenv("AC7d96067e5b157e7e9f9f6542464da441");
    public static final String AUTH_TOKEN = System.getenv("8c2f26b7fd72ba6249f6bd36742de913");


    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    public SimpleMailMessage simpleMailMessage;

    @Override
    public void sendEmailAlert(String to, String subject, String text, String pathToAttachment) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@techIntello.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendSmsAlert(String to, String text) {
        Twilio.init("AC7d96067e5b157e7e9f9f6542464da441", "92d67d19231e45c3cc11545f3ede2b43");
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(to),
                        new com.twilio.type.PhoneNumber("+15734946076"), text)
                .create();
    }

}
