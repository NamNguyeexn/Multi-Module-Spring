package com.check.observe;

import com.check.DTO.ENUM.LOGIN_STATUS;
import com.check.models.User;
import com.check.services.impl.IEmailProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AlertService implements Subject {
    @Autowired
    private IEmailProxy emailProxy;
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(User user, LOGIN_STATUS status) {
        for (Observer o : observers) {
            switch (o.getClass().getSimpleName()) {
                case "MailObserver":
                    String body = o.update(user, status);
                    emailProxy.sendEmail(user.getEmail(), user.getEmail(), "Has A New Request Login", body);
                    log.info("Sending mail");
                    continue;
                case "LogObserver":
                    String logStr = o.update(user, status);
                    log.info(logStr);
                    continue;
                default:
                    throw new IllegalArgumentException("Unsupported typeClass: " + o.getClass().getName().split("@")[0]);
            }
        }
    }

    @Override
    public void freeUpObservers() {
        if (!observers.isEmpty()) {
            observers.clear();
        }
    }
}
