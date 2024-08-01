package com.check.DTO;

import com.check.models.User;
import lombok.Getter;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Getter
@Scope("singleton")
public final class UsersCheckedIn {
    private static UsersCheckedIn instance;
    public List<User> users = new ArrayList<>();

    private UsersCheckedIn(){    }
    public static UsersCheckedIn getInstance(){
        if(instance == null){
            instance = new UsersCheckedIn();
        }
        return instance;
    }
    public static void addUser(User user){
        UsersCheckedIn.getInstance().getUsers().add(user);
    }

}
