package com.check.factory.impl;

import com.check.DTO.Meeting;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;
import com.check.services.impl.IOfflineRoom;
import com.check.services.impl.IOnlineRoom;
import com.check.factory.MeetingFactory;
import com.check.models.ENUM.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeetingFactoryImpl implements MeetingFactory {
    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private IRoomService roomService;
    @Override
    public Meeting createMeeting(String meetingType) {
        return switch (meetingType) {
            case "ONLINE" -> new IOnlineRoom();
            case "OFFLINE" -> new IOfflineRoom(appointmentService, roomService);
            default -> throw new IllegalArgumentException("Invalid meeting type");
        };
    }
}
