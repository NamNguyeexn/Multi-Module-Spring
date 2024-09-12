package com.check.decorator.decorator;

import com.check.decorator.models.AlertDecorator;
import com.check.decorator.models.IAlert;

public class AlertSystem extends AlertDecorator {
    public AlertSystem(IAlert iAlert) {
        super(iAlert);
    }
    @Override
    public String send(String message) {
        message += "From System";
        return iAlert.send(message);
    }
}
