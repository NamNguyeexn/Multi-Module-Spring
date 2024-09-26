package com.check.facades;

import com.check.dto.AppointmentFormInput;
import com.check.models.ENUM.Role;
import com.check.models.User;
import com.check.services.proxy.IEmailProxy;
import com.check.services.facade.IMeetingService;
import com.check.services.IUserService;
import com.check.services.impl.IMeetingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class MeetingFacade implements IMeetingService {
    @Autowired
    private IMeetingServiceImpl meetingService;
//    @Autowired
//    private IEmailServiceImpl emailService;
    @Autowired
    private IEmailProxy emailProxy;
    @Autowired
    private IUserService userService;

    @Override
    public String createMeeting(AppointmentFormInput appointmentFormInput) {
        String host = appointmentFormInput.getHostMail();
        String info = meetingService.createMeeting(appointmentFormInput);
        Map<String, Role> joins = new HashMap<>();
        List<String> listName = new ArrayList<>();
        for(String s : appointmentFormInput.getJoinid()){
            Optional<User> u = userService.getUserById(Integer.parseInt(s));
            if(u.isPresent()){
                User user = u.get();
                joins.put(user.getEmail(), user.getRole());
                listName.add(user.getEmail());
            }
        }
        String[] joinsName = listName.toArray(new String[0]);
        appointmentFormInput.setJoinid(joinsName);
        String subject = appointmentFormInput.getName();
//        emailService.sendEmails(host, joins, subject, info);
        emailProxy.sendEmails(host, joins, subject, info);
        return info;
    }
}
