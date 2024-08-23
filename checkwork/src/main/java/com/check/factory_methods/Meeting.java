package com.check.factory_methods;

import org.springframework.stereotype.Service;

@Service
public interface Meeting {
    String getMeetingType();
    String getRoomName();
}
