package com.check.DTO;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Meeting {
    String getMeetingType();
    String prepareRoom(List<String> datas);
    String toString(String[] data);
    String getRoomName();
}
