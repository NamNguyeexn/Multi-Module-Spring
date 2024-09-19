package com.check.observe;

public class ConcreteObserver2 implements Observer{
    @Override
    public void update(Subject subject) {
        System.out.println("Observer 2 is updated");
    }
}
