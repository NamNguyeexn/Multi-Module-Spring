package com.check.DTO;

import com.check.models.User;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Scope
public final class UsersCheckedIn {
    private static UsersCheckedIn instance;
    public List<User> users;

    private UsersCheckedIn(List<User> users){
        this.users = users;
    }
    public static UsersCheckedIn getInstance(){
        List<User> users1 = new ArrayList<>();
        if(instance == null){
            instance = new UsersCheckedIn(users1);
        }
        return instance;
    }
    public static void addUser(User user){
        UsersCheckedIn usersCheckedIn = UsersCheckedIn.getInstance();
        usersCheckedIn.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
