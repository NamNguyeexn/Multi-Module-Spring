package com.check.decorator;

import com.check.decorator.decorator.AlertEmail;
import com.check.decorator.decorator.AlertSystem;
import com.check.decorator.models.Alert;
import com.check.decorator.models.IAlert;

public class DecoratorMain {
    public static void main(String[] args) {
        IAlert alert = new Alert();
        String message = "This is message";
        System.out.println(alert.send(message));
        alert = new AlertEmail(alert);
        System.out.println(alert.send(message));
        alert = new AlertSystem(alert);
        System.out.println(alert.send(message));
    }
}
