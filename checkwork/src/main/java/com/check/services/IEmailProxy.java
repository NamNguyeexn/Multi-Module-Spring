package com.check.services;

import com.check.models.ENUM.Role;
import com.check.services.impl.IEmailServiceImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IEmailProxy implements IEmailService{
    private final IEmailServiceImpl emailService;
    public IEmailProxy(IEmailServiceImpl iEmailService){
        this.emailService = iEmailService;
    }
    @Override
    public void sendEmails(String from, Map<String, Role> to, String subject, String body) {
        Map<Role, Boolean> listJoin = new HashMap<>();
        int primary = 0;
        for(Role r : to.values()){
            listJoin.put(r, false);
            if(r.compareTo(Role.ADMIN) == 0) primary ++;
        }
        for(Map.Entry<String, Role> m : to.entrySet()){
            if(m.getValue().compareTo(Role.ADMIN) == 0){
                emailService.sendEmail(from, m.getKey(), subject, "Dear " + body);
                primary --;
                to.remove(m.getKey(), m.getValue());
            } else if (primary == 0){
                for(Map.Entry<String, Role> map : to.entrySet()){
                    emailService.sendEmail(from, m.getKey(), subject, body);
                }
                break;
            }
        }
    }

    @Override
    public void sendEmail(String from, String to, String subject, String body) {
        emailService.sendEmail(from, to, subject, body);
    }
}
