package com.check.observe;

import com.check.DTO.ENUM.LOGIN_STATUS;
import com.check.models.User;
import org.springframework.stereotype.Component;

@Component
public interface Observer {
    String update(User user, LOGIN_STATUS status);
}
