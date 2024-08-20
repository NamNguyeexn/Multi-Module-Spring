package com.check.factory.impl;

import com.check.DTO.Meeting;
import com.check.DTO.OfflineRoom;
import com.check.DTO.OnlineRoom;
import com.check.factory.MeetingFactory;
import com.check.models.ENUM.Type;
import org.springframework.stereotype.Component;

@Component
public class MeetingFactoryImpl implements MeetingFactory {
    @Override
    public Meeting createMeeting(String meetingType) {
        return switch (meetingType) {
            case "ONLINE" -> new OnlineRoom();
            case "OFFLINE" -> new OfflineRoom();
            default -> throw new IllegalArgumentException("Invalid meeting type");
        };
    }
}
