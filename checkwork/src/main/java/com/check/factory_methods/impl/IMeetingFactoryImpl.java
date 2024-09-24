package com.check.factory_methods.impl;

import com.check.factory_methods.IMeetingFactory;
import com.check.services.factory.IOfflineRoomService;
import com.check.services.factory.IOnlineRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IMeetingFactoryImpl implements IMeetingFactory {
    @Autowired
    private IOnlineRoomService onlineRoomService;
    @Autowired
    private IOfflineRoomService offlineRoomService;
    @Override
    public String createMeeting(List<String> meetingType) {
        return switch (meetingType.get(0)) {
            case "ONLINE" :
                 yield onlineRoomService.prepareMeeting(meetingType);
            case "OFFLINE" :
                yield offlineRoomService.prepareMeetingHandlers(meetingType);
            default :
                throw new IllegalArgumentException("Invalid meeting type");
        };
    }
}
