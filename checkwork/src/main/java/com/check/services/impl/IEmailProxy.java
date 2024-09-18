package com.check.services.impl;

import com.check.models.ENUM.Role;
import com.check.services.IEmailService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class IEmailProxy implements IEmailService {
    private final IEmailServiceImpl emailService;
    public IEmailProxy(IEmailServiceImpl iEmailService){
        this.emailService = iEmailService;
    }
    @Override
    public void sendEmails(String from, Map<String, Role> to, String subject, String body) {
        List<Map.Entry<String, Role>> recipients = new ArrayList<>(to.entrySet());
        recipients.sort(Comparator.comparing(entry -> entry.getValue().compareTo(Role.ADMIN)));
        Set<String> adminMails = new HashSet<>();
        for (Map.Entry<String, Role> entry : recipients){
            String mail = entry.getKey();
            Role role = entry.getValue();
            if(role == Role.ADMIN && !adminMails.contains(mail)){
                adminMails.add(mail);
                sendEmail(from, mail, subject, "Dear " + body);
            } else {
                sendEmail(from, mail, subject, body);
            }
        }
    }

    @Override
    public void sendEmail(String from, String to, String subject, String body) {
        emailService.sendEmail(from, to, subject, body);
    }

    @Override
    public void sendEmails(String from, String[] to, String subject, String body) {
        emailService.sendEmails(from, to, subject, body);
    }
}
