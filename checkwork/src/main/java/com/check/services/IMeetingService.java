package com.check.services;

import com.check.DTO.AppointmentFormInput;
import com.check.DTO.Meeting;
import com.check.factory.MeetingFactory;
import com.check.models.Appointment;
import com.check.models.ENUM.Type;
import com.check.services.impl.IOfflineRoom;
import com.check.services.impl.IOnlineRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class IMeetingService {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    @Autowired
    private MeetingFactory meetingFactory;
    public String createMeeting(AppointmentFormInput appointmentFormInput){
        Meeting meeting = null;
        meeting = meetingFactory.createMeeting(String.valueOf(appointmentFormInput.getType()));
        if(meeting.getMeetingType().compareTo("ONLINE") == 0) {
            String send = "ONLINE";
            List<String> sendList = new ArrayList<>();
            sendList.add(send);
            return meeting.prepareRoom(sendList);
        } else {
            List<String> sendList = new ArrayList<>();
            String send = "OFFLINE";
            String[] nums = appointmentFormInput.getJoinid().split(",");
            sendList.add(send);
            sendList.add(String.valueOf(nums.length));
            sendList.add(appointmentFormInput.getStart());
            sendList.add(appointmentFormInput.getEnd());
            return meeting.prepareRoom(sendList);
        }
    }
    public String getRoomName(AppointmentFormInput appointmentFormInput){
        Meeting meeting = meetingFactory.createMeeting(String.valueOf(appointmentFormInput.getType()));
        if(meeting.getMeetingType().compareTo("ONLINE") == 0) {
            return meeting.getRoomName();
        } else {
            return meeting.getRoomName();
        }
    }

}
