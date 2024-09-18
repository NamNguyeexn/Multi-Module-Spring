package com.check.mediator.chat;

import com.check.models.User;

public class ChatClient {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        UserMed userMed1 = new UserMedImpl(mediator, User.builder()
                .employeeCode("BN001")
                .build());
        UserMed userMed2 = new UserMedImpl(mediator, User.builder()
                .employeeCode("BN002")
                .build());
        UserMed userMed3 = new UserMedImpl(mediator, User.builder()
                .employeeCode("BN003")
                .build());
        UserMed userMed4 = new UserMedImpl(mediator, User.builder()
                .employeeCode("BN004")
                .build());
        mediator.addUser(userMed1)
                .addUser(userMed2)
                .addUser(userMed3)
                .addUser(userMed4);
        userMed1.send("Hello from user 1");
    }
}
