package com.check.mediator.services;

import com.check.mediator.models.GroupChat;
import com.check.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class ChatMed {
    protected GroupChatService groupChatService;

    public ChatMed(GroupChatService groupChatService) {
        this.groupChatService = groupChatService;
    }

    public abstract boolean send(String message, User user, GroupChat groupChat);

}
