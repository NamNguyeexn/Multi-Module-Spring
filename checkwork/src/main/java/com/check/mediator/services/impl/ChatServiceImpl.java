package com.check.mediator.services.impl;

import com.check.mediator.models.GroupChat;
import com.check.mediator.services.ChatMed;
import com.check.mediator.services.ChatService;
import com.check.mediator.services.GroupChatService;
import com.check.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private GroupChatService groupChatService;

    @Override
    public boolean sendMessage(String message, User user, GroupChat groupChat, ChatMed chatMed) {
        if (chatMed == null) return false;
        chatMed.send(message, user, groupChat);
        return true;
    }

}
