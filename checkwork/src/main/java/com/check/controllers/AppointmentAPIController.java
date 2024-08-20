package com.check.controllers;

import com.check.DTO.AppointmentFormInput;
import com.check.JWT.JwtTokenService;
import com.check.mapper.AppointmentMapper;
import com.check.models.Appointment;
import com.check.services.IAppointmentService;
import com.check.services.IMeetingService;
import com.check.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class AppointmentAPIController {
    @Qualifier("IAppointmentService")
    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private IMeetingService meetingService;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Qualifier("IUserService")
    @Autowired
    private IUserService userService;
    @RequestMapping("/createAppointment")
    ResponseEntity<?> createAppointment(HttpServletRequest request, @Valid AppointmentFormInput appointmentFormInput) {
        String username = jwtTokenService.getUsername(
                request
                        .getHeader(HttpHeaders.AUTHORIZATION)
                        .split(" ")[1].trim()
        );
        String info = meetingService.createMeeting(appointmentFormInput);
        String name = meetingService.getRoomName(appointmentFormInput);
        appointmentService.saveAppointment(appointmentMapper.toAppointment(appointmentFormInput, info, name));
        return ResponseEntity.ok().body(appointmentService.getAppointmentByHostAndStart(userService.getUserByUsername(username).get().getId(),appointmentFormInput.getStart()));
    }
}
