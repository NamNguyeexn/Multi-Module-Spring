package com.check.observe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObserverMain {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        MyService myService = new MyService(subject);
        myService.initialize();
        myService.triggerUpdate();
    }
}
