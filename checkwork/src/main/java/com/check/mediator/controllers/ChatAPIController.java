package com.check.mediator.controllers;

import com.check.JWT.JwtTokenService;
import com.check.mediator.DTO.RegisterChatDTO;
import com.check.mediator.models.GroupChat;
import com.check.mediator.services.ChatMed;
import com.check.mediator.services.GroupChatService;
import com.check.mediator.services.impl.ChatMedImpl;
import com.check.models.User;
import com.check.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/chat")
public class ChatAPIController {
    @Autowired
    private GroupChatService groupChatService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IUserService userService;
    @GetMapping()
    public ResponseEntity<Map<String, List<GroupChat>>> getGroupChatsByUser(HttpServletRequest request){
        Map<String, List<GroupChat>> response = new HashMap<>();
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        List<GroupChat> chatList = groupChatService.getGroupChatJoined(user.get().getEmail());
        if (chatList.isEmpty()){
            response.put("User didn't join any chats", null);
            return ResponseEntity.badRequest().body(response);
        } else {
            response.put("Found chats", chatList);
            return ResponseEntity.ok().body(response);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, GroupChat>> createGroupChat(@Valid @RequestBody RegisterChatDTO registerChatDTO,
                                                                  HttpServletRequest request){
        Map<String, GroupChat> response = new HashMap<>();
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        GroupChat groupChat = groupChatService.createGroupChat(Arrays.asList(registerChatDTO.getEmail()), user.get().getEmail());
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
                                              @RequestAttribute(name = "message") String message,
                                              HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Optional<GroupChat> groupChat = groupChatService.getGroupChatById(id);
        if (groupChat.isEmpty()){
            return ResponseEntity.badRequest().body("Not Found Group");
        }
        ChatMed chatMed = new ChatMedImpl(
                User.builder()
                        .email(user.get().getEmail())
                        .build(),
                groupChatService,
                groupChat.get());
        if(chatMed.send(message)){
            return ResponseEntity.ok().body("Send message to everyone in " + groupChat.get().getName());
        } else {
            return ResponseEntity.badRequest().body("Found group but here's nobody in group");
        }
    }
}
