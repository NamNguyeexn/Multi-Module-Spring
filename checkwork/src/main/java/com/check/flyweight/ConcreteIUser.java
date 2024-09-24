package com.check.flyweight;

public class ConcreteIUser implements IUser {
    private final String name;
    private final String email;

    public ConcreteIUser(String name, String email) {
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
