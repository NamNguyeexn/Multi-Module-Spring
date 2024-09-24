package com.check.services.impl;

import com.check.models.ENUM.Role;
import com.check.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Primary
@EnableAsync
public class IEmailProxy implements IEmailService {
    @Autowired
    private IEmailServiceImpl emailService;
//    public IEmailProxy(IEmailServiceImpl iEmailService){
//        this.emailService = iEmailService;
//    }
    @Override
    @Async("MailExecutor")
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
    @Async("MailExecutor")
//    @Async
    public void sendEmail(String from, String to, String subject, String body) {
        emailService.sendEmail(from, to, subject, body);
    }

    @Override
    @Async("MailExecutor")
    public void sendEmails(String from, String[] to, String subject, String body) {
        emailService.sendEmails(from, to, subject, body);
    }
}
