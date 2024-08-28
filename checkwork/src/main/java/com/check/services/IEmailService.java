package com.check.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public interface IEmailService {
    void sendEmails(String from, String[] to, String subject, String body);
    void sendEmail(String from, String to, String subject, String body);
}
