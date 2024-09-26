package com.check.observe;

import com.check.dto.ENUM.LOGIN_STATUS;
import com.check.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class LogObserver implements IObserver {
    @Override
    public String update(User user, LOGIN_STATUS status) {
        return "Logger : " + user.getUsername() + " at " + LocalDateTime.now() + " Status : " + status;
    }
}
