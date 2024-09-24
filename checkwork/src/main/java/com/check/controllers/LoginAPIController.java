package com.check.controllers;

import com.check.DTO.ENUM.LOGIN_STATUS;
import com.check.DTO.RegisterFormInput;
import com.check.DTO.RegisterFormOutput;
import com.check.JWT.TokenJWT;
import com.check.DTO.UserInput;
import com.check.JWT.JwtTokenService;
import com.check.mapper.IHumanMapper;
import com.check.models.Human;
import com.check.models.User;
import com.check.observe.AlertService;
import com.check.observe.LogObserver;
import com.check.observe.MailObserver;
import com.check.services.IHumanService;
import com.check.services.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Tag(name = "Login")
@RestController
@RequestMapping("/api")
@Slf4j
public class LoginAPIController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IHumanService humanService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IHumanMapper humanMapper;
    @Autowired
    private AlertService alertService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserInput userInput){
        Map<String, User> response = new HashMap<>();
        MailObserver mailObserver = new MailObserver();
        LogObserver logObserver = new LogObserver();
        alertService.freeUpObservers();
        try {
            Optional<User> user = userService.getUserByUsername(userInput.getUsername());
            if(user.isEmpty()) {
                alertService.addObserver(mailObserver);
                alertService.addObserver(logObserver);
                alertService.notifyObservers(user.get(), LOGIN_STATUS.FAILURE);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            else if (passwordEncoder.matches(userInput.getPassword(), user.get().getPassword())){
                log.info("LOGIN API CONTROLLER - LOGIN - FOUND USER");
                Optional<Human> human = humanService.getHumanById(user.get().getHumanid());
                if(human.isEmpty()){
                    alertService.addObserver(mailObserver);
                    alertService.addObserver(logObserver);
                    log.info("LOGIN API CONTROLLER - LOGIN - NOT FOUND HUMAN");
                    response.put("LOGIN API CONTROLLER - LOGIN - NOT FOUND HUMAN", null);
                    alertService.notifyObservers(user.get(), LOGIN_STATUS.FAILURE);
                    return ResponseEntity.badRequest().body(response);
                } else {
                    alertService.addObserver(mailObserver);
                    alertService.addObserver(logObserver);
                    String JWT = this.jwtTokenService.generateAccessToken(user.get());
                    TokenJWT token = new TokenJWT(JWT, new Date(System.currentTimeMillis() + (1000*60*8)), human.get().getName());
                    response.put(JWT, user.get());
                    alertService.notifyObservers(user.get(), LOGIN_STATUS.SUCCESS);
                    return ResponseEntity.status(HttpStatus.OK).body(JWT);
                }
            } else {
                alertService.removeObserver(mailObserver);
                alertService.removeObserver(logObserver);
                alertService.notifyObservers(user.get(), LOGIN_STATUS.FAILURE);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.info("-----------------------------------");
            log.info("LOGIN API CONTROLLER - LOGIN - EXCEPTION {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
    @PostMapping("/register")
    public ResponseEntity<Map<String, RegisterFormOutput>> register(@RequestBody RegisterFormInput registerFormInput){
        Map<String, RegisterFormOutput> response = new HashMap<>();
        try {
            Optional<Human> human = userService.getHumanByPhone(registerFormInput.getPhone());
            Optional<User> userCheck = userService.getUserByUsername(registerFormInput.getUsername());
            Optional<User> mailCheck = userService.getUserByEmail(registerFormInput.getEmail());
            if(human.isPresent()){
                response.put("LOGIN API CONTROLLER - REGISTER - USE PHONE NUMBER EXITS", null);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
            } else if(userCheck.isPresent()) {
                response.put("LOGIN API CONTROLLER - REGISTER - USERNAME EXITS", null);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
            } else if (mailCheck.isPresent()) {
                response.put("LOGIN API CONTROLLER - REGISTER - EMAIL EXITS", null);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
            } else {
                String password = registerFormInput.getPassword();
                log.info("PASSWORD BEFORE ENCODE : " + password);
                registerFormInput.setPassword(passwordEncoder.encode(registerFormInput.getPassword()));
                Optional<User> user = userService.saveNewUser(registerFormInput);
                if (user.isEmpty()){
                    log.info("LOGIN API CONTROLLER - REGISTER - CANT REGISTER");
                    response.put("LOGIN API CONTROLLER - REGISTER - CANT REGISTER", null);
                    return ResponseEntity.badRequest().body(response);
                }
                log.info("LOGIN API CONTROLLER - REGISTER - SUCCESS");
                User u = user.get();
                RegisterFormOutput registerFormOutput =
                        IHumanMapper.INSTANCE.userToRegisterFormOutput(u, registerFormInput, password);
                //
                response.put("LOGIN API CONTROLLER - REGISTER - SUCCESS ", registerFormOutput);
                return ResponseEntity.ok().body(response);
            }

        } catch (Exception e){
            response.put("LOGIN API CONTROLLER - REGISTER - EXCEPTION : " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
