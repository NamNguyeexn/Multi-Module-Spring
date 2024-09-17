package com.check.controllers;

import com.check.DTO.AppointmentFormInput;
import com.check.DTO.AppointmentFormOutput;
import com.check.JWT.JwtTokenService;
import com.check.adapters.ScheduleAdapter;
import com.check.facades.MeetingFacade;
import com.check.mapper.AppointmentMapper;
import com.check.mapper.ScheduleMapper;
import com.check.models.Appointment;
import com.check.models.User;
import com.check.services.IAppointmentService;
import com.check.services.IHumanService;
import com.check.services.IScheduleService;
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
import java.util.Arrays;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/appointment")
public class AppointmentAPIController {
    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IHumanService humanService;
    @Autowired
    private MeetingFacade meetingFacade;
    @Autowired
    private IUserService userService;
    @Autowired
    private IScheduleService scheduleService;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private ScheduleAdapter scheduleAdapter;
    @RequestMapping("/create")
    ResponseEntity<AppointmentFormOutput> createAppointment(
            HttpServletRequest request, @Valid @RequestBody AppointmentFormInput appointmentFormInput
    ) {
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            User u = user.get();
            String joinid = Arrays.toString(appointmentFormInput.getJoinid());
            System.out.println(joinid);
            appointmentFormInput.setHostMail(userService.getUserById(u.getHumanid()).get().getEmail());
            /////
            String meetingInfo = meetingFacade.createMeeting(appointmentFormInput);
            /////
            String[] info = meetingInfo.split("@");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

            Appointment appointment = appointmentMapper.toAppointment(
                    appointmentFormInput,
                    joinid,
                    u.getId(),
                    info[1],
                    info[0],
                    LocalDateTime.parse(appointmentFormInput.getStart(), formatter),
                    LocalDateTime.parse(appointmentFormInput.getEnd(), formatter)
            );
            //
            appointmentService.saveAppointment(appointment);
            //
            String joinnames = scheduleAdapter.toJoinsname(appointment.getJoinid());
            scheduleService.save(scheduleMapper.toSchedule(
                    appointment,
                    humanService.getHumanById(user.get().getHumanid()).get().getName(),
                    joinnames,
                    appointment.getStart().toString(),
                    appointment.getEnd().toString()
                    ));
            //
            Optional<Appointment> res = appointmentService.getAppointmentByHostAndStart(u.getId(),appointmentFormInput.getStart());
            if(res.isEmpty()){
                return ResponseEntity.badRequest().body(null);
            }

            AppointmentFormOutput appointmentFormOutput = appointmentMapper.toAppointmentFormOutput(
                    appointmentFormInput, u.getEmployeeCode(), info[1], info[0]);
            return ResponseEntity.ok().body(appointmentFormOutput);
        }
        return ResponseEntity.status(401).body(null);
    }
}
