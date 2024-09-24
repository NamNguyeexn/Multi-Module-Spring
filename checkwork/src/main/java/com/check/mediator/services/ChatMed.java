package com.check.mediator.services;

import com.check.mediator.models.GroupChat;
import com.check.models.User;
import org.springframework.stereotype.Component;

@Component
public abstract class ChatMed {
    protected IGroupChatService IGroupChatService;

    public ChatMed(IGroupChatService IGroupChatService) {
        this.IGroupChatService = IGroupChatService;
    }

    public abstract boolean send(String message, User user, GroupChat groupChat);

}
