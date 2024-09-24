package com.check.mediator.services;

import com.check.mediator.models.GroupChat;

import java.util.List;
import java.util.Optional;

public interface IGroupChatService {
    Optional<GroupChat> getGroupChatById(int id);
    List<GroupChat> getGroupChatJoined(String email);
    GroupChat createGroupChat(List<String> emails, String email);
    GroupChat addUser(String email, int id);
    boolean removeUser(String email, int id);
}
