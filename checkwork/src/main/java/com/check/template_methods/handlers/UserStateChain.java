package com.check.template_methods.handlers;

import com.check.template_methods.DTO.RequestDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserStateChain {
    private UserStateHandler userStateHandler;
    private final List<UserStateHandler> list = new ArrayList<>();

    public UserStateChain() {
    }
    public UserStateChain(UserStateHandler userStateHandler) {
        this.userStateHandler = userStateHandler;
    }
    public void handlers(RequestDTO request){
        list.forEach(u -> u.handler(request));
    }
    public UserStateChain setHandlers(UserStateHandler userStateHandler) {
        this.userStateHandler = userStateHandler;
        list.add(userStateHandler);
        return this;
    }
}
