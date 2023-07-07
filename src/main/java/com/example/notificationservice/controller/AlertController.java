package com.example.notificationservice.controller;

import com.example.notificationservice.domain.Content;
import com.example.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/triggerEmail")
    public ResponseEntity<String> sendEmailNotification(@RequestBody Content emailContent){
        emailService.sendEmailAlert(emailContent.getEmailTo(), emailContent.getSubject(), emailContent.getContent(), "");
        return new ResponseEntity<>("Email sent", HttpStatus.OK);
    }

    @PostMapping("triggerSmsAlert/{phoneNumber}/{text}")
    public ResponseEntity<String> sendSMSAlert(@PathVariable String phoneNumber, @PathVariable String text){
        emailService.sendSmsAlert(phoneNumber, text);
        return new ResponseEntity<>("SMS is delivered", HttpStatus.OK);
    }

}
