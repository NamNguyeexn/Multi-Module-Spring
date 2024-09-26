package com.check.template_methods.handlers;

import com.check.models.UserState;
import com.check.services.state.IUserStateService;
import com.check.template_methods.DTO.RequestDTO;
import com.check.template_methods.UserTemplateMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserStateHandler extends UserTemplateMethod implements UserStateHandler {
    public GetUserStateHandler() {
        super();
    }
    @Override
    public void getUserState(RequestDTO request) {
        UserState userState = request.getUserState();
        if(userState == null) {
            request.setMessage("User State not found");
        }
    }

    @Override
    public void createMessageResponse(RequestDTO request) {}

    @Override
    public UserStateChain handler(RequestDTO request) {
        getUserState(request);
        return new UserStateChain(this);
    }
}
