package com.check.controllers;

import com.check.DTO.*;
import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.models.WorkHour;
import com.check.services.TestService;
import com.check.services.UserService;
import com.check.services.WorkHourService;
import com.check.services.impl.TestServiceImpl1;
import com.check.services.impl.TestServiceImpl2;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.check.services.TestService;

import java.util.Optional;
import java.util.Stack;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private WorkHourService workHourService;
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("Service1")
    private TestService testService1;
    @Autowired
    @Qualifier("Service2")
    private TestService testService2;
    @GetMapping()
    public ResponseEntity<?> localhost(HttpServletRequest request){
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        UserInput userInput = new UserInput(username, "passs");
        UserOutput userOutput = new UserOutput(userInput.getUsername());
        return ResponseEntity.ok().body(userOutput);
    }
    @GetMapping("/getLastWorkHour")
    public ResponseEntity<WorkHour> testGetLastWorkHour(HttpServletRequest request) {
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        Optional<User> user = userService.getUserByUsername(username);
        if(user.isEmpty()) {
            log.info("TEST CONTROLLER - GET LAST WORK HOUR - NULL USER");
            return ResponseEntity.badRequest().body(null);
        } else {
            Optional<WorkHour> workHour = workHourService.testGetLastWorkHour(user.get());
            if(workHour.isEmpty()){
                log.info("TEST CONTROLLER - GET LAST WORK HOUR - NULL USER");
                return ResponseEntity.badRequest().body(null);
            } else {
                return ResponseEntity.ok().body(workHour.get());
            }
        }
    }
    @GetMapping("/show1")
    public ResponseEntity<String> getShow(){
        return ResponseEntity.ok().body(
                testService1.getHello() +
                        "\n" +
                        testService1.getData() +
                        "\n" +
                        testService2.getHello() +
                        "\n" +
                        testService2.getData()
        );
    }
    @GetMapping("/init1")
    public ResponseEntity<String> getInit1(){
        testService1.addData();
        testService2.addData();
        return ResponseEntity.ok().body("ADDED DATA TO TEST SERVICE 1, 2");
    }


}
