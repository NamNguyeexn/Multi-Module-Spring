package com.check.observe;

import com.check.dto.ENUM.LOGIN_STATUS;
import com.check.models.User;
import com.check.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MailObserver implements IObserver {
    @Autowired
    private IUserService userService;

    @Override
    public String update(User user, LOGIN_STATUS status) {
        return "Dear everyone, I'm " + user.getUsername() + "!"
                + "\nYou login into system at " + LocalDateTime.now() + " Status : " + status;
    }
}
