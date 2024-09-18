package com.check.mediator.chat;

import com.check.models.User;

public abstract class UserMed {
    protected ChatMediator chatMediator;
    protected User user;

    public UserMed(ChatMediator mediator, User user){
        this.chatMediator = mediator;
        this.user = user;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}
