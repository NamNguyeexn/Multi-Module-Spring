package com.common.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConvertStrTime {
    public ConvertStrTime() {
    }
    public static LocalDateTime convertStringToLocalDateTime(String time){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(time, format);
    }
    public static String convertLocalDateTimeToString(LocalDateTime timeLCD){
        return timeLCD.toString();
    }
}
