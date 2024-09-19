package com.check.mediator.services.impl;

import com.check.mediator.models.GroupChat;
import com.check.mediator.services.ChatMed;
import com.check.mediator.services.GroupChatService;
import com.check.models.User;
import com.check.services.impl.IEmailProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ChatMedImpl extends ChatMed {
    @Autowired
    private final IEmailProxy emailService;
    public ChatMedImpl(GroupChatService groupChatService, IEmailProxy emailService) {
        super(groupChatService);
        this.emailService = emailService;
    }
    @Override
    public boolean send(String message, User user, GroupChat groupChat) {
        List<String> emails = Arrays.asList(groupChat.getEmails());
        if (emails.isEmpty()) return false;
        emails.forEach(e -> {
                    if(!user.getEmail().equals(e)){
                        emailService.sendEmail(user.getEmail(), e, groupChat.getName(), message);
                    }
                });
        for(String email : emails){
            if(user.getEmail() != email){
                emailService.sendEmail(user.getEmail(), email, groupChat.getName(), message);
            }
        }
        return true;
    }
}
