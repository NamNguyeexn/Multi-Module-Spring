package com.check.observe;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    private final ConcreteSubject subject;

    public MyService(ConcreteSubject subject) {
        this.subject = subject;
    }

    @PostConstruct
    public void initialize(){
        ConcreteObserver1 observer1 = new ConcreteObserver1();
        ConcreteObserver2 observer2 = new ConcreteObserver2();
        subject.registerObserver(observer1);
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.removeObserver(observer2);
    }
    public void triggerUpdate(){
        subject.notifyObservers();
    }
}
