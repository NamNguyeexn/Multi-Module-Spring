package com.check.mediator.services;

import com.check.mediator.models.GroupChat;
import com.check.models.User;

public abstract class ChatMed {
    protected GroupChatService groupChatService;
    protected User user;
    protected GroupChat groupChat;

    public ChatMed(User user, GroupChatService groupChatService, GroupChat groupChat) {
        this.groupChatService = groupChatService;
        this.user = user;
        this.groupChat = groupChat;
    }

    public abstract boolean send(String message);

//    public abstract void receive(String message, int id);
}
