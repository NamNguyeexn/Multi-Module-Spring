package com.check.factory;

import com.check.DTO.Meeting;
import org.springframework.stereotype.Service;

@Service
public interface MeetingFactory {
    Meeting createMeeting(String meetingType);
}
