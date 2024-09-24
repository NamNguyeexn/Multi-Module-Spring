package com.check.mediator.services.impl;

import com.check.mediator.models.GroupChat;
import com.check.repositories.JPARepository.GroupChatRepository;
import com.check.mediator.services.IGroupChatService;
import com.check.models.User;
import com.check.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GroupChatServiceImpl implements IGroupChatService {
    @Autowired
    private GroupChatRepository groupChatRepository;
    @Autowired
    private IUserService userService;

    @Override
    public Optional<GroupChat> getGroupChatById(int id) {
        return groupChatRepository.findById(id);
    }

    @Override
    public List<GroupChat> getGroupChatJoined(String email) {
        List<GroupChat> res = new ArrayList<>();
        groupChatRepository.findAll().stream()
                .filter(gc -> Arrays.stream(gc.getEmails()).toList().contains(email))
                .forEach(res::add);
        return res;
    }

    @Override
    public GroupChat createGroupChat(List<String> emails, String email) {
        Optional<User> user = userService.getUserByEmail(email);
        if(user.isPresent()){
            GroupChat groupChat = GroupChat.builder()
                    .name(user.get().getDepartment().toString() + " Group")
                    .emails(emails.toArray(new String[0]))
                    .createAt(LocalDateTime.now())
                    .build();
            groupChatRepository.save(groupChat);
            return groupChat;
        } else return null;
    }

    @Override
    public GroupChat addUser(String email, int id) {
        Optional<GroupChat> groupChat = getGroupChatById(id);
        groupChat.ifPresent(gc -> {
            List<String> emails = Arrays.asList(gc.getEmails());
            emails.add(email);
            gc.setEmails(emails.toArray(new String[0]));
            groupChatRepository.save(gc);
        });
        return groupChat.get();
    }

    @Override
    public boolean removeUser(String email, int id) {
        Optional<GroupChat> groupChat = getGroupChatById(id);
        boolean res = false;
        if(groupChat.isPresent()){
            List<String> emails = Arrays.asList(groupChat.get().getEmails());
            emails.remove(email);
            groupChat.get().setEmails(emails.toArray(new String[0]));
            groupChatRepository.save(groupChat.get());
            res = true;
        }
        return res;
    }
}
