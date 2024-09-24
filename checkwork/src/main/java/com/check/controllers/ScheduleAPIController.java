package com.check.controllers;

import com.check.DTO.iterator.*;
import com.check.DTO.ScheduleOutput;
import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.repositories.JPARepository.ScheduleRepository;
import com.check.services.IHumanService;
import com.check.services.IScheduleService;
import com.check.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @Autowired
    private ScheduleRepository scheduleRepository;
//    @Autowired
//    private

    @GetMapping("/byHost")
    public ResponseEntity<Map<String, List<ScheduleOutput>>> getAllSchedule(HttpServletRequest request) {
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, List<ScheduleOutput>> response = new HashMap<>();
        System.out.println("ID : " + user.get().getId());
        List<ScheduleOutput> schedules = scheduleService.getSchedulesByHost(user.get().getId());
        if (schedules.isEmpty()) {
            String message = "IUser didn't host any appointment";
            response.put(message, null);
            return ResponseEntity.badRequest().body(response);
        } else {
            String message = "Found appointment host by " + humanService.getHumanById(user.get().getHumanid()).get().getName();
            response.put(message, schedules);
            return ResponseEntity.ok().body(response);
        }
    }

    @GetMapping("/byJoin")
    public ResponseEntity<Map<String, List<ScheduleOutput>>> getAllSchedulesByJoin(HttpServletRequest request) {
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, List<ScheduleOutput>> response = new HashMap<>();
        List<ScheduleOutput> schedules = scheduleService.getSchedulesByJoin(user.get().getId());
        if (schedules.isEmpty()) {
            String message = "IUser didn't join any appointment";
            response.put(message, null);
            return ResponseEntity.badRequest().body(response);
        } else {
            String message = "Found appointment join by " + humanService.getHumanById(user.get().getHumanid()).get().getName();
            response.put(message, schedules);
            return ResponseEntity.ok().body(response);
        }
    }

    @GetMapping("/byType/")
    public ResponseEntity<Map<String, ScheduleList>> getSchedulesByType(
            HttpServletRequest request,
            @RequestParam(name = "type") String type) {
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Map<String, ScheduleList> response = new HashMap<>();
        IScheduleListFactory factory;
        if (type.contains("day")) {
            factory = new ScheduleByDay(scheduleRepository);
            ScheduleList schedules = factory.createScheduleList();
            response.put("Schedule by " + LocalDate.now(), schedules);
            return ResponseEntity.ok().body(response);
        } else if (type.contains("week")) {
            factory = new ScheduleByWeek(scheduleRepository);
            ScheduleList schedules = factory.createScheduleList();
            response.put("Schedule by " + LocalDate.now(), schedules);
            return ResponseEntity.ok().body(response);
        } else if (type.contains("month")) {
            factory = new ScheduleByMonth(scheduleRepository);
            ScheduleList schedules = factory.createScheduleList();
            response.put("Schedule by " + LocalDate.now(), schedules);
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
