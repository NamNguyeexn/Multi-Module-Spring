package com.check.factory_methods.impl;

import com.check.factory_methods.MeetingFactory;
import com.check.services.impl.IOfflineRoomService;
import com.check.services.impl.IOnlineRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeetingFactoryImpl implements MeetingFactory {
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
                yield offlineRoomService.prepareMeeting(meetingType);
            default :
                throw new IllegalArgumentException("Invalid meeting type");
        };
    }

//    @Override
//    public String prepareMeeting(List<String> data) {
//        Meeting meeting = createMeeting(data.get(0));
//        switch ()
//        return "";
//    }
}
