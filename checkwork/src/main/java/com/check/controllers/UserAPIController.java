package com.check.controllers;

import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api")
public class UserAPIController {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @GetMapping("/user/home")
    public ResponseEntity<Map<String, User>> getHomepage(HttpServletRequest request) {
        Map<String, User> response = new HashMap<>();
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if(user.isPresent()) {
                response.put("FOUND USER", user.get());
                return ResponseEntity.ok().body(response);
            }
            else {
                String message = "NULL USER \n "
                        + "USERNAME : "
                        + username;
                log.info(message);
                response.put(message, null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("SERVER ERROR", null);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
