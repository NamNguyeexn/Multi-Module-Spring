package com.check.services.impl;

import com.check.models.ENUM.Role;
import com.check.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IEmailServiceImpl implements IEmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmails(String from, Map<String, Role> listEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        List<String> toList = new ArrayList<>(listEmail.keySet());
        String[] to = toList.toArray(new String[0]);
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setSentDate(Date.valueOf(LocalDate.now()));
        mailSender.send(message);
    }

    @Override
    public void sendEmail(String from, String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
