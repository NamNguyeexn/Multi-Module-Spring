package com.check.controllers;

import com.check.DTO.RegisterFormInput;
import com.check.DTO.RegisterFormOutput;
import com.check.DTO.Token;
import com.check.DTO.UserInput;
import com.check.JWT.JwtTokenService;
import com.check.mapper.HumanMapper;
import com.check.models.Human;
import com.check.models.User;
import com.check.services.IHumanService;
import com.check.services.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    private IUserService IUserService;
    @Autowired
    private IHumanService IHumanService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
    private final HumanMapper humanMapper;

    public LoginAPIController(HumanMapper humanMapper) {
        this.humanMapper = humanMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserInput userInput){
        Map<String, User> response = new HashMap<>();
        try {
            Optional<User> user = IUserService.getUserByUsername(userInput.getUsername());
            if(user.isEmpty()) {
                log.info("-----------------------------------");
                log.info("LOGIN API CONTROLLER - LOGIN - NOT FOUND USER");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            else if (passwordEncoder.matches(userInput.getPassword(), user.get().getPassword())){
                log.info("-----------------------------------");
                log.info("LOGIN API CONTROLLER - LOGIN - FOUND USER");
                Optional<Human> human = IHumanService.getHumanById(user.get().getHumanid());
                if(human.isEmpty()){
                    log.info("-----------------------------------");
                    log.info("LOGIN API CONTROLLER - LOGIN - NOT FOUND HUMAN");
                    response.put("LOGIN API CONTROLLER - LOGIN - NOT FOUND HUMAN", null);
                    return ResponseEntity.badRequest().body(response);
                } else {
                    String JWT = this.jwtTokenService.generateAccessToken(user.get());
                    Token token = new Token(JWT, new Date(System.currentTimeMillis() + (1000*60*8)), human.get().getName());
                    log.info("OUTPUT TOKEN : " + token + " USER : " + user.get().getEmployeeCode());
                    response.put(JWT, user.get());
                    return ResponseEntity.status(HttpStatus.OK).body(JWT);
                }
            } else {
                log.info("-----------------------------------");
                log.info("LOGIN API CONTROLLER - LOGIN - WRONG PASSWORD");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.info("-----------------------------------");
            log.info("LOGIN API CONTROLLER - LOGIN - EXCEPTION " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
    @PostMapping("/register")
    public ResponseEntity<Map<String, RegisterFormOutput>> register(@Valid @RequestBody RegisterFormInput registerFormInput){
        Map<String, RegisterFormOutput> response = new HashMap<>();
        try {
            Optional<Human> human = IUserService.getHumanByPhone(registerFormInput.getPhone());
            Optional<User> userCheck = IUserService.getUserByUsername(registerFormInput.getUsername());
            if(human.isPresent()){
                log.info("-----------------------------------");
                log.info("LOGIN API CONTROLLER - REGISTER - USE PHONE NUMBER EXITS");
                response.put("LOGIN API CONTROLLER - REGISTER - USE PHONE NUMBER EXITS", null);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
            } else if(userCheck.isPresent()){
                log.info("-----------------------------------");
                log.info("LOGIN API CONTROLLER - REGISTER - USERNAME EXITS");
                response.put("LOGIN API CONTROLLER - REGISTER - USERNAME EXITS", null);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
            } else {
                String password = registerFormInput.getPassword();
                log.info("PASSWORD BEFORE ENCODE : " + password);
                registerFormInput.setPassword(passwordEncoder.encode(registerFormInput.getPassword()));
                IHumanService.saveNewHuman(humanMapper.registerFormInputToHuman(registerFormInput, java.sql.Date.valueOf(registerFormInput.getDob())));
                Optional<User> user = IUserService.saveNewUser(registerFormInput);
                if (user.isEmpty()){
                    log.info("----------------------------------");
                    log.info("LOGIN API CONTROLLER - REGISTER - CANT REGISTER");
                    response.put("LOGIN API CONTROLLER - REGISTER - CANT REGISTER", null);
                    return ResponseEntity.badRequest().body(response);
                }
                log.info("-----------------------------------");
                log.info("LOGIN API CONTROLLER - REGISTER - SUCCESS");
                RegisterFormOutput registerFormOutput = humanMapper.userToRegisterFormOutput(user.get(), registerFormInput, password);
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
