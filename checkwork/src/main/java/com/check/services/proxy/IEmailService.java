package com.check.services.proxy;

import com.check.models.ENUM.Role;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@EnableAsync(proxyTargetClass = true)
public interface IEmailService {
    void sendEmails(String from, Map<String, Role> to, String subject, String body);
    void sendEmail(String from, String to, String subject, String body);
    void sendEmails(String from, String[] to, String subject, String body);
}
