package com.check.mediator.chat;

import com.check.models.User;

public class UserMedImpl extends UserMed{
    public UserMedImpl(ChatMediator mediator, User user) {
        super(mediator, user);
    }

    @Override
    public void send(String message) {
        System.out.println(this.user.getEmployeeCode() + " : sending message = " + message);
        chatMediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.user.getEmployeeCode() + " : received message = " + message);
    }
}
