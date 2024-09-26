package com.check.observe;

import com.check.dto.ENUM.LOGIN_STATUS;
import com.check.models.User;
import org.springframework.stereotype.Component;

@Component
public interface ISubject {
    void addObserver(IObserver IObserver);
    void removeObserver(IObserver IObserver);
    void notifyObservers(User user, LOGIN_STATUS status);
    void freeUpObservers();
}
