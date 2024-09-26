package com.check.observe;

import com.check.dto.ENUM.LOGIN_STATUS;
import com.check.models.User;
import org.springframework.stereotype.Component;

@Component
public interface IObserver {
    String update(User user, LOGIN_STATUS status);
}
