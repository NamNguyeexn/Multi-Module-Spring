package com.check.flyweight;

import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    private final Map<String, ConcreteIUser> users = new HashMap<>();
    public ConcreteIUser getConcreteUser(String name, String email){
        String key = name + email;
        ConcreteIUser concreteUser = users.get(key);
        if(concreteUser == null){
            concreteUser = new ConcreteIUser(name, email);
            users.put(name, concreteUser);
        }
        return concreteUser;
    }
}
