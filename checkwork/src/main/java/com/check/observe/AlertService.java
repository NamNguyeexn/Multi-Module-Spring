package com.check.observe;

import com.check.DTO.ENUM.LOGIN_STATUS;
import com.check.models.User;
import com.check.services.proxy.IEmailProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AlertService implements ISubject {
    @Autowired
    private IEmailProxy emailProxy;
    private final List<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver IObserver) {
        observers.add(IObserver);
    }

    @Override
    public void removeObserver(IObserver IObserver) {
        observers.remove(IObserver);
    }

    @Override
    public void notifyObservers(User user, LOGIN_STATUS status) {
        for (IObserver o : observers) {
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
