package com.check.decorator.decorator;

import com.check.decorator.models.AlertDecorator;
import com.check.decorator.models.IAlert;

public class AlertEmail extends AlertDecorator {
    public AlertEmail(IAlert iAlert) {
        super(iAlert);
    }
    @Override
    public String send(String message) {
        message += "From Email";
        return iAlert.send(message);
    }
}
