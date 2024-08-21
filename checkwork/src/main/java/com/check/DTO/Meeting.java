package com.check.DTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Meeting {
    String getMeetingType();
    String prepareRoom(List<String> datas);
    String toString(String[] data);
    String getRoomName();
}
