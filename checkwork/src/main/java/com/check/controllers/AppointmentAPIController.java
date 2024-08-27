package com.check.controllers;

import com.check.DTO.AppointmentFormInput;
import com.check.DTO.AppointmentFormOutput;
import com.check.JWT.JwtTokenService;
import com.check.mapper.AppointmentMapper;
import com.check.models.Appointment;
import com.check.models.User;
import com.check.services.IAppointmentService;
import com.check.services.IMeetingService;
import com.check.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/appointment")
public class AppointmentAPIController {
//    @Qualifier("IAppointmentService")
    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private IMeetingService meetingService;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private JwtTokenService jwtTokenService;
//    @Qualifier("IUserService")
    @Autowired
    private IUserService userService;
    @RequestMapping("/create")
    ResponseEntity<AppointmentFormOutput> createAppointment(HttpServletRequest request, @Valid @RequestBody AppointmentFormInput appointmentFormInput) {
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            User u = user.get();
            String meetingInfo = meetingService.createMeeting(appointmentFormInput);
            String[] info = meetingInfo.split("@");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

            //Tao builder
            Appointment appointment = appointmentMapper.toAppointment(
                    appointmentFormInput,
                    u.getId(),
                    info[1],
                    info[0],
                    LocalDateTime.parse(appointmentFormInput.getStart(), formatter),
                    LocalDateTime.parse(appointmentFormInput.getEnd(), formatter)
            );
            //
            appointmentService.saveAppointment(appointment);
            Optional<Appointment> res = appointmentService.getAppointmentByHostAndStart(u.getId(),appointmentFormInput.getStart());
            if(res.isEmpty()){
                return ResponseEntity.badRequest().body(null);
            }
            String[] joinsname = new String("Default,Joins,Name").split(",");
            AppointmentFormOutput appointmentFormOutput = appointmentMapper.toAppointmentFormOutput(
                    appointmentFormInput, u.getEmployeeCode(), joinsname, info[1]);
            return ResponseEntity.ok().body(appointmentFormOutput);
        }
        return ResponseEntity.status(401).body(null);
    }
}
