package com.check.controllers;

import com.check.DTO.*;
import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.models.WorkHour;
import com.check.services.UserService;
import com.check.services.WorkHourService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.check.services.TestService;

import java.util.List;
import java.util.Optional;

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
    private TestService testService;
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
    @GetMapping("/getSum")
    public ResponseEntity<String> getHello(){
        List<User> users = UsersCheckedIn.getInstance().getUsers();
        return ResponseEntity.ok().body(
                testService.getHelloService()
                        + " : "
                + " \n USERS CHECKED IN "
                + users.size()
        );
    }

}
