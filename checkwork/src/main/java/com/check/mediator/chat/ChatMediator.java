package com.check.mediator.chat;

public interface ChatMediator {
    void sendMessage(String message, UserMed userMed);
    ChatMediator addUser(UserMed userMed);
    ChatMediator removeUser(UserMed userMed);
}
