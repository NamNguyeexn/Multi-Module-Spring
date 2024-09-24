package com.check.services.facade;

import com.check.DTO.AppointmentFormInput;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public interface IMeetingService {
    String createMeeting(AppointmentFormInput appointmentFormInput);
//    String getRoomName();
}