package com.check.mediator.services.impl;

import com.check.mediator.models.GroupChat;
import com.check.mediator.services.ChatMed;
import com.check.mediator.services.IChatService;
import com.check.mediator.services.IGroupChatService;
import com.check.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ChatServiceImpl implements IChatService {
    @Autowired
    private IGroupChatService IGroupChatService;

    @Override
    public boolean sendMessage(String message, User user, GroupChat groupChat, ChatMed chatMed) {
        if (chatMed == null) return false;
        chatMed.send(message, user, groupChat);
        return true;
    }

}
