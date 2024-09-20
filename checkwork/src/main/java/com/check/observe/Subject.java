package com.check.observe;

import com.check.DTO.ENUM.LOGIN_STATUS;
import com.check.models.User;
import org.springframework.stereotype.Component;

@Component
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(User user, LOGIN_STATUS status);
    void freeUpObservers();
}
