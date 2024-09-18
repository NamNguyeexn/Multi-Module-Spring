package com.check.services;

import com.check.models.ENUM.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IEmailService {
    void sendEmails(String from, Map<String, Role> to, String subject, String body);
    void sendEmail(String from, String to, String subject, String body);
    void sendEmails(String from, String[] to, String subject, String body);
}
