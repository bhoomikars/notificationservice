package com.example.notificationservice.service;

public interface EmailService {
    void sendEmailAlert(String to, String subject, String text, String pathToAttachment);
    void sendSmsAlert(String to, String text);


}
