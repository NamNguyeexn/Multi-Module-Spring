package com.check.template_methods.handlers;

import com.check.JWT.JwtTokenService;
import com.check.services.IUserService;
import com.check.template_methods.DTO.RequestDTO;
import com.check.template_methods.UserTemplateMethod;
import org.springframework.stereotype.Component;

@Component
public class CreateMessageResponse extends UserTemplateMethod implements UserStateHandler{

    @Override
    protected void getUserState(RequestDTO request) {}

    @Override
    protected void createMessageResponse(RequestDTO request) {
        if(!request.getMessage().contains("USER") || !request.getMap().isEmpty()) {
            request.setMessage("Got error");
        }
        else {
            switch (request.getRequestType()) {
                case Demote -> request.setMessage("We so sorry that have to inform you: You have been demoted");
                case Promote -> request.setMessage("Congratulation! You have been promoted! " +
                    "Let's try more and more to have a bigger success in the future");
                case GetSalary -> request.setMessage("Got your salary");
                case GetUserState -> request.setMessage("Got your state");
                default -> throw new IllegalArgumentException("Invalid request type");
            }
        }
    }
    @Override
    public UserStateChain handler(RequestDTO request) {
        createMessageResponse(request);
        return new UserStateChain(this);
    }
}
