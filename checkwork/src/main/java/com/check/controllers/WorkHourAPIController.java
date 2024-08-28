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
import org.springframework.beans.factory.annotation.Qualifier;
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

    @RequestMapping()
    public ResponseEntity<List<WorkHour>> getListWorkHourByUsername(HttpServletRequest request) {
        log.info("WORK HOUR API CONTROLLER - GET WORK HOUR BY USERNAME");
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if(user.isEmpty()) {
                log.info("WORK HOUR API CONTROLLER - GET WORK HOUR BY USERNAME - NULL USER");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            Optional<List<WorkHour>>workHours = workHourService.getAllWorkHourByUsername(user.get());
            log.info("WORK HOUR API CONTROLLER - GET WORK HOUR BY USERNAME - FOUND USER, WORKHOUR");
            return workHours.map(hours -> ResponseEntity.ok().body(hours)).orElseGet(() ->{
                log.info("WORK HOUR API CONTROLLER - GET WORK HOUR BY USERNAME - NULL WORK HOURS");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            });
        } catch (Exception e) {
            log.info("WORK HOUR API CONTROLLER - GET WORK HOUR BY USERNAME - GOT EXCEPTION " + e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/checkin")
    public ResponseEntity<Map<String, Optional<CheckInOutput>>> getCheckIn(HttpServletRequest request) {
        log.info("WORK HOUR API CONTROLLER - GET CHECK IN");
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        StringBuilder message = new StringBuilder();
        Map<String, Optional<CheckInOutput>> response = new HashMap<>();
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if(user.isEmpty()) {
                log.info("WORK HOUR API CONTROLLER - GET CHECK IN - NULL USER");
                message.append("WORK HOUR API CONTROLLER - GET CHECK IN - NULL USER");
                response.put(message.toString(), Optional.empty());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            Optional<CheckInOutput> checkIn = workHourService.checkin(user.get());
            if(checkIn.isEmpty()){
                log.info("WORK HOUR API CONTROLLER - GET CHECK IN - CANT CHECK IN");
                message.append("WORK HOUR API CONTROLLER - GET CHECK IN - CANT CHECK IN");
//                response.put(message.toString(), checkIn.get().values().stream().findFirst());
                response.put(message.toString(), Optional.empty());
                return ResponseEntity.badRequest().body(response);
            } else {
                log.info("WORK HOUR API CONTROLLER - GET CHECK IN - CHECKED IN");
                message.append("WORK HOUR API CONTROLLER - GET CHECK IN - CHECKED IN");
                response.put(message.toString(), checkIn);
                // tao moi instance class
//                UsersCheckedIn.addUser(user.get());
//                response.put()
                return ResponseEntity.ok().body(response);
            }
        } catch (Exception e) {
            log.info("WORK HOUR API CONTROLLER - GET CHECK IN - GOT EXCEPTION " + e.getMessage());
            message.append("WORK HOUR API CONTROLLER - GET CHECK IN - GOT EXCEPTION ").append(e.getMessage());
            response.put(message.toString(), Optional.empty());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/checkout")
    public ResponseEntity<Map<String, Optional<CheckOutOutput>>> getCheckOut(HttpServletRequest request) {
        log.info("WORK HOUR API CONTROLLER - GET CHECK OUT");
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        StringBuilder message = new StringBuilder();
        Map<String, Optional<CheckOutOutput>> response = new HashMap<>();
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if(user.isEmpty()) {
                log.info("WORK HOUR API CONTROLLER - GET CHECK OUT - NULL USER");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            LocalDateTime end = LocalDateTime.now();
            Optional<CheckOutOutput> checkOut = workHourService.checkout(end, user.get());
            log.info("WORK HOUR API CONTROLLER - GET CHECK OUT - CHECKED IN");
            if (checkOut.isEmpty()) {
                log.info("WORK HOUR API CONTROLLER - GET CHECK OUT - CHECK OUT EMPTY");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            } else {
                log.info("WORK HOUR API CONTROLLER - GET CHECK OUT - SUCCESS CHECK OUT");
                message.append("WORK HOUR API CONTROLLER - GET CHECK OUT - SUCCESS CHECK OUT");
                response.put(message.toString(), checkOut);
//                return ResponseEntity.ok().body(
//                        new CheckOutOutput(
//                                checkOut.get().getStart(),
//                                checkOut.get().getEnd(),
//                                user.get().getEmployeeCode(),
//                                checkOut.get().getStatus(),
//                                "done")
//                );
//                return null;
            }
        } catch (Exception e) {
            log.info("WORK HOUR API CONTROLLER - GET CHECK OUT - SERVER ERROR : " + e.getMessage());
            message.append("WORK HOUR API CONTROLLER - GET CHECK OUT - SERVER ERROR : ").append(e.getMessage());
            response.put(message.toString(), Optional.empty());
            return ResponseEntity.badRequest().body(response);
        }
        return null;
    }
}
