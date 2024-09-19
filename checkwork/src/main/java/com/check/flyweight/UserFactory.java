package com.check.flyweight;

import com.check.models.Room;

import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    private final Map<String, ConcreteUser> users = new HashMap<>();
    public ConcreteUser getConcreteUser(String name, String email){
        String key = name + email;
        ConcreteUser concreteUser = users.get(key);
        if(concreteUser == null){
            concreteUser = new ConcreteUser(name, email);
            users.put(name, concreteUser);
        }
        return concreteUser;
    }
}
