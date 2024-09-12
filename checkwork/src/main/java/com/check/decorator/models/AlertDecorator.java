package com.check.decorator.models;

public abstract class AlertDecorator implements IAlert {
    protected IAlert iAlert;
    public AlertDecorator(IAlert iAlert){
        this.iAlert = iAlert;
    }
    @Override
    public String send(String message) {
        return iAlert.send(message);
    }
}
