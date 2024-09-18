package com.check.mediator.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator{
    private final List<UserMed> userMeds;

    public ChatMediatorImpl() {
        this.userMeds = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, UserMed userMed) {
        for(UserMed u : this.userMeds){
            if(u != userMed){
                u.receive(message);
            }
        }
    }

    @Override
    public ChatMediator addUser(UserMed userMed) {
        this.userMeds.add(userMed);
        return this;
    }

    @Override
    public ChatMediator removeUser(UserMed userMed) {
        this.userMeds.remove(userMed);
        return this;
    }
}
