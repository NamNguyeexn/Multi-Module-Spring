package com.check.decorator.models;

public class Alert implements IAlert{
//    private final String message = "This is message";

    @Override
    public String send(String message) {
        return message;
    }
}
