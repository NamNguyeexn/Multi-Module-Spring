package com.check.observe;

import org.springframework.stereotype.Component;

@Component
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
