package com.check.services.impl;

import com.check.DTO.AppointmentFormInput;
import com.check.factory_methods.IMeetingFactory;
import com.check.services.facade.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class IMeetingServiceImpl implements IMeetingService {
    @Autowired
    private IMeetingFactory IMeetingFactory;
    @Override
    public String createMeeting(AppointmentFormInput appointmentFormInput) {
        List<String> data = new ArrayList<>();
        data.add(appointmentFormInput.getType());
        data.add(String.valueOf(appointmentFormInput.getJoinid().length));
        data.add(appointmentFormInput.getStart());
        data.add(appointmentFormInput.getEnd());
        return IMeetingFactory.createMeeting(data);
    }
}
