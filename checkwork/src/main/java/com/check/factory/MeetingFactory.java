package com.check.factory;

import com.check.DTO.Meeting;
import com.check.models.ENUM.Type;
import org.springframework.stereotype.Component;

@Component
public interface MeetingFactory {
    Meeting createMeeting(String meetingType);
}
