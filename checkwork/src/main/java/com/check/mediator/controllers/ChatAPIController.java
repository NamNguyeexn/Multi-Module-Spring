package com.check.mediator.controllers;

import com.check.jwt.JwtTokenService;
import com.check.mediator.dto.RegisterChatDTO;
import com.check.mediator.models.GroupChat;
import com.check.mediator.services.ChatMed;
import com.check.mediator.services.IChatService;
import com.check.mediator.services.IGroupChatService;
import com.check.mediator.services.impl.ChatMedImpl;
import com.check.models.User;
import com.check.services.IUserService;
import com.check.services.proxy.IEmailProxy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/chat")
public class ChatAPIController {
    @Autowired
    private IGroupChatService IGroupChatService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IEmailProxy emailProxy;
    @Autowired
    private IChatService chatService;
    @GetMapping()
    public ResponseEntity<Map<String, List<GroupChat>>> getGroupChatsByUser(HttpServletRequest request){
        Map<String, List<GroupChat>> response = new HashMap<>();
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        List<GroupChat> chatList = IGroupChatService.getGroupChatJoined(user.get().getEmail());
        if (chatList.isEmpty()){
            response.put(user.get().getEmail() + " didn't join any chats", null);
            return ResponseEntity.badRequest().body(response);
        } else {
            response.put("Found chats joined by " + user.get().getEmail(), chatList);
            return ResponseEntity.ok().body(response);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, GroupChat>> createGroupChat(@Valid @RequestBody RegisterChatDTO registerChatDTO,
                                                                  HttpServletRequest request){
        Map<String, GroupChat> response = new HashMap<>();
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, String> emails = new HashMap<>();
        for(String s : registerChatDTO.getEmails()){
            emails.put(s, s);
        }
        emails.put(user.get().getEmail(), user.get().getEmail());
        GroupChat groupChat = IGroupChatService.createGroupChat(emails.values().stream().toList(), user.get().getEmail());
        if(groupChat != null){
            response.put("Created group", groupChat);
            return ResponseEntity.ok().body(response);
        } else {
            response.put("Cant create group", null);
            return ResponseEntity.badRequest().body(response);
        }
    }
    @PostMapping("/send/{id}")
    public ResponseEntity<String> sendMessage(@RequestParam(name = "id") int id,
                                              @RequestBody String message,
                                              HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Optional<GroupChat> groupChat = IGroupChatService.getGroupChatById(id);
        if (groupChat.isEmpty()){
            return ResponseEntity.badRequest().body("Not Found Group");
        }
        ChatMed chatMed = new ChatMedImpl(IGroupChatService, emailProxy);
        if(chatService.sendMessage(message, user.get(), groupChat.get(), chatMed)){
            return ResponseEntity.ok().body("Send message to everyone in " + groupChat.get().getName());
        } else {
            return ResponseEntity.badRequest().body("Found group but here's nobody in group");
        }
    }
}
