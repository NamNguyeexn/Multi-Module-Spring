package com.check.controllers;

import com.check.jwt.JwtTokenService;
import com.check.command.DTO.ChangeInfoInputDTO;
import com.check.models.PerEvaluation;
import com.check.models.User;
import com.check.models.UserState;
import com.check.services.IPerEvaluationService;
import com.check.services.IUserService;
import com.check.services.state.IUserStateService;
import com.check.state_dp.IUserState;
import com.check.template_methods.DTO.ENUM.RequestType;
import com.check.template_methods.DTO.RequestDTO;
import com.check.template_methods.UserStateTemplateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserAPIController {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserStateService userStateService;
    @Autowired
    private IPerEvaluationService evaService;
    @Autowired
    private UserStateTemplateService userStateTemplateService;
    @GetMapping()
    public ResponseEntity<Map<String, User>> getHomepage(HttpServletRequest request) {
        Map<String, User> response = new HashMap<>();
        String username = jwtTokenService.getUsername(request);
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
    @PostMapping("/change")
    public ResponseEntity<Map<String, User>> changeInfo(@Valid @RequestBody ChangeInfoInputDTO changeInfoInputDTO,
                                                        HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, User> response = new HashMap<>();
        if(userService.executeCommand(changeInfoInputDTO, user.get())) {
            User newUser = userService.getUserById(user.get().getId()).get();
            response.put("Change user info success", newUser);
            return ResponseEntity.ok().body(response);
        } else {
            response.put("Info didn't be changed", user.get());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @PostMapping("/undo")
    public ResponseEntity<Map<String, User>> undoChangeInfo(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, User> response = new HashMap<>();
        if(userService.undoCommand(user.get())) {
            User oldUser = userService.getUserById(user.get().getId()).get();
            oldUser.setPassword(passwordEncoder.encode(oldUser.getPassword()));
            response.put("Undo change user info success", oldUser);
            return ResponseEntity.ok().body(response);
        } else {
            response.put("Info didn't be changed", user.get());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/state")
    public ResponseEntity<Map<String, UserState>> getUserState(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        RequestDTO requestDTO = RequestDTO.builder()
                .request(request)
                .requestType(RequestType.GetUserState)
                .message(userService.getUserByUsername(
                        jwtTokenService.getUsername(request)).get().getEmployeeCode()
                )
                .userId(user.get().getId())
                .build();
        userStateTemplateService.processes(requestDTO);
        Map<String, UserState> map = new HashMap<>();
        map.put(requestDTO.getMessage(), requestDTO.getUserState());
        if(map.isEmpty()) return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok().body(map);
    }
    @GetMapping("/promote")
    public ResponseEntity<Map<String, User>> promote(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, User> map = new HashMap<>();
        Optional<UserState> userState = userStateService.getUserStateByUserId(user.get().getId());
        if(userState.isEmpty()) {
            map.put("Null User Stage", null);
            return ResponseEntity.badRequest().body(map);
        }
        IUserState iUserState = userStateService.handle(userState.get());
        iUserState.promote(userState.get());
        userStateService.saveUserState(userState.get());
        map.put(userState.get().getState().toString(), user.get());
        return ResponseEntity.ok().body(map);
    }
    @GetMapping("/demote")
    public ResponseEntity<Map<String, User>> demote(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, User> map = new HashMap<>();
        Optional<UserState> userState = userStateService.getUserStateByUserId(user.get().getId());
        if(userState.isEmpty()) {
            map.put("Null User Stage", null);
            return ResponseEntity.badRequest().body(map);
        }
        IUserState iUserState = userStateService.handle(userState.get());
        iUserState.demote(userState.get());
        userStateService.saveUserState(userState.get());
        map.put(userState.get().getState().toString(), user.get());
        return ResponseEntity.ok().body(map);
    }
    @GetMapping("/salary")
    public ResponseEntity<Map<String, UserState>> getSalary(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, UserState> map = new HashMap<>();
        Optional<UserState> userState = userStateService.getUserStateByUserId(user.get().getId());
        List<PerEvaluation> perEvaluations = evaService.getPEsByUserStateId(userState.get().getId());
        if(perEvaluations.isEmpty()) {
            map.put("Work Hour null", null);
            return ResponseEntity.badRequest().body(map);
        }
        map.put(evaService.getSalary(perEvaluations).toString(), userState.get());
        return ResponseEntity.ok().body(map);
    }

}
