package com.check.controllers;

import com.check.DTO.ScheduleOutput;
import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.services.IHumanService;
import com.check.services.IScheduleService;
import com.check.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleAPIController {
    @Autowired
    private IHumanService humanService;
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IScheduleService scheduleService;
//    @Autowired
//    private

    @GetMapping("/byHost")
    public ResponseEntity<Map<String, List<ScheduleOutput>>> getAllSchedule(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, List<ScheduleOutput>> response = new HashMap<>();
        System.out.println("ID : " + user.get().getId());
        List<ScheduleOutput> schedules = scheduleService.getSchedulesByHost(user.get().getId());
        if(schedules.isEmpty()){
            String message = "User didn't host any appointment";
            response.put(message, null);
            return ResponseEntity.badRequest().body(response);
        } else {
            String message = "Found appointment host by " + humanService.getHumanById(user.get().getHumanid()).get().getName();
            response.put(message, schedules);
            return ResponseEntity.ok().body(response);
        }
    }

    @GetMapping("/byJoin")
    public ResponseEntity<Map<String, List<ScheduleOutput>>> getAllSchedulesByJoin(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, List<ScheduleOutput>> response = new HashMap<>();
        List<ScheduleOutput> schedules = scheduleService.getSchedulesByJoin(user.get().getId());
        if(schedules.isEmpty()){
            String message = "User didn't join any appointment";
            response.put(message, null);
            return ResponseEntity.badRequest().body(response);
        } else {
            String message = "Found appointment join by " + humanService.getHumanById(user.get().getHumanid()).get().getName();
            response.put(message, schedules);
            return ResponseEntity.ok().body(response);
        }
    }
    @GetMapping("/byType/{type}")
    public ResponseEntity<String> getSchedulesByType(HttpServletRequest request, @PathVariable String type){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        return ResponseEntity.ok().body(null);
    }
}
