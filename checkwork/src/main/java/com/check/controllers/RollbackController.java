package com.check.controllers;

import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.services.IUserService;
import com.check.services.IWorkHourService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/fullAccess")
public class RollbackController {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IWorkHourService IWorkHourService;
    @Autowired
    private IUserService IUserService;
    @DeleteMapping("/deleteWorkHourById/{id}")
    public ResponseEntity<String> deleteWorkHourById(@RequestParam int id, HttpServletRequest request){
        return ResponseEntity.ok().body(IWorkHourService.deleteWorkHourById(id));
    }
    @DeleteMapping("/deleteAllWorkHour")
    public ResponseEntity<String> deleteAllWorkHour(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = IUserService.getUserByUsername(username);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND USER");
        }
        IWorkHourService.getAllWorkHourByUsername(user.get()).ifPresent(
                workHours -> workHours.forEach(
                        workHour -> IWorkHourService.deleteWorkHourById(workHour.getId())
                )
        );
        return ResponseEntity.ok().body("Success");
    }
}
