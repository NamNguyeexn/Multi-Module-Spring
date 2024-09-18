package com.check.mediator.services.impl;

import com.check.mediator.models.GroupChat;
import com.check.mediator.services.ChatMed;
import com.check.mediator.services.GroupChatService;
import com.check.models.User;
import com.check.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ChatMedImpl extends ChatMed {
    @Autowired
    private IEmailService emailService;
    public ChatMedImpl(User user, GroupChatService groupChatService, GroupChat groupChat) {
        super(user, groupChatService, groupChat);
    }

    @Override
    public boolean send(String message) {
        List<String> emails = Arrays.asList(groupChat.getEmails());
        if (emails.isEmpty()) return false;
        emails.forEach(e -> emailService.sendEmail(user.getEmail(), e, groupChat.getName(), message));
        return true;
    }
}
