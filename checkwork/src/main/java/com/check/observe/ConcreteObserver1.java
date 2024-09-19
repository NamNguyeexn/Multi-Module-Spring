package com.check.observe;

public class ConcreteObserver1 implements Observer{
    @Override
    public void update(Subject subject) {
        System.out.println("Observer 1 is updated");
    }
}
