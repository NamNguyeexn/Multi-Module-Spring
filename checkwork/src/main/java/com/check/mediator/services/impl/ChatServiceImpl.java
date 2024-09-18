package com.check.mediator.services.impl;

import com.check.mediator.models.GroupChat;
import com.check.mediator.services.ChatMed;
import com.check.mediator.services.ChatService;
import com.check.mediator.services.GroupChatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ChatServiceImpl implements ChatService {
    @Autowired
    private GroupChatService groupChatService;
    @Override
    public boolean sendMessage(String message, ChatMed chatMed) {
//        Optional<GroupChat> groupChat = groupChatService.getGroupChatById(chatMed.);
//        if(groupChat.isEmpty()){
//            return false;
//        }
        if (chatMed == null) return false;
        chatMed.send(message);
        return true;
    }
}
