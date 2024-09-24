package com.check.factory_methods;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMeetingFactory {
    //chua name, cac thong tin chung
    String createMeeting(List<String> meetingType);
}
