package com.check.controllers;

import com.check.DTO.CheckInOutput;
import com.check.DTO.CheckOutOutput;
//import com.check.DTO.UsersCheckedIn;
import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.models.WorkHour;
import com.check.services.IUserService;
import com.check.services.IWorkHourService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/workhour")
public class WorkHourAPIController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IWorkHourService workHourService;
    @Autowired
    private JwtTokenService jwtTokenService;

    @RequestMapping("")
    public ResponseEntity<List<WorkHour>> getListWorkHourByUsername(HttpServletRequest request) {
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if(user.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            Optional<List<WorkHour>>workHours = workHourService.getAllWorkHourByUsername(user.get());
            return workHours.map(hours -> ResponseEntity.ok().body(hours)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
        } catch (Exception e) {
            log.info("EXCEPTION " + e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/checkin")
    public ResponseEntity<Map<String, CheckInOutput>> getCheckIn(HttpServletRequest request) {
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        StringBuilder message = new StringBuilder();
        Map<String, CheckInOutput> response = new HashMap<>();
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if(user.isEmpty()) {
                message.append("NULL USER");
                response.put(message.toString(), null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            Optional<CheckInOutput> checkIn = workHourService.checkin(user.get());
            if(checkIn.isEmpty()){
                message.append("CANT CHECK IN");
                response.put(message.toString(), null);
                return ResponseEntity.badRequest().body(response);
            } else {
                message.append("CHECKED IN");
                response.put(message.toString(), checkIn.get());
                return ResponseEntity.ok().body(response);
            }
        } catch (Exception e) {
            log.info("EXCEPTION CHECK IN : " + e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/checkout")
    public ResponseEntity<Map<String, CheckOutOutput>> getCheckOut(HttpServletRequest request) {
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        StringBuilder message = new StringBuilder();
        Map<String, CheckOutOutput> response = new HashMap<>();
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if(user.isEmpty()) {
                log.info("NULL USER");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            LocalDateTime end = LocalDateTime.now();
            Optional<CheckOutOutput> checkOut = workHourService.checkout(end, user.get());
//            log.info("CHECKED IN");
            if (checkOut.isEmpty()) {
                log.info("CHECK OUT EMPTY");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            } else {
                message.append("SUCCESS CHECK OUT");
                response.put(message.toString(), checkOut.get());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            log.info("EXCEPTION CHECK OUT : " + e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
}
