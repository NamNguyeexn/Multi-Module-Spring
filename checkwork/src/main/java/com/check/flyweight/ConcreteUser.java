package com.check.flyweight;

public class ConcreteUser implements User {
    private final String name;
    private final String email;

    public ConcreteUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getEmail() {
        return email;
    }
}
