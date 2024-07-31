package com.common.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class GenerateWorkHourCode {
    public static String generateWorkHourCode(LocalDateTime start, int userid) {
        return start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + userid;
    }
}
