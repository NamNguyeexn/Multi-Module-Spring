package com.check.factory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Meeting {
    String getMeetingType();
    String getRoomName();
}
