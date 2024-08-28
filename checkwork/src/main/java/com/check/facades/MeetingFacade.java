package com.check.facades;

import com.check.DTO.AppointmentFormInput;
import com.check.models.User;
import com.check.services.IMeetingService;
import com.check.services.IUserService;
import com.check.services.impl.IEmailServiceImpl;
import com.check.services.impl.IMeetingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
@Slf4j
public class MeetingFacade implements IMeetingService {
    @Autowired
    private IMeetingServiceImpl meetingService;
    @Autowired
    private IEmailServiceImpl emailService;
    @Autowired
    private IUserService userService;

    @Override
    public String createMeeting(AppointmentFormInput appointmentFormInput) {
        String host = appointmentFormInput.getHostMail();
        String info = meetingService.createMeeting(appointmentFormInput);
        List<String> joins = new ArrayList<>();
        for(String s : appointmentFormInput.getJoinid()){
            Optional<User> u = userService.getUserById(Integer.parseInt(s));
            u.ifPresent(user -> joins.add(user.getEmail()));
        }
        String[] joinsName = joins.toArray(new String[0]);
        appointmentFormInput.setJoinid(joinsName);
        String subject = appointmentFormInput.getName();
        emailService.sendEmails(host, joinsName, subject, info);
        return info;
    }
}
