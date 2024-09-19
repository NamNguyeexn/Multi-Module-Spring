package com.check.mediator.services;

import com.check.mediator.models.GroupChat;
import com.check.models.User;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    boolean sendMessage(String message, User user, GroupChat groupChat, ChatMed chatMed);
}
