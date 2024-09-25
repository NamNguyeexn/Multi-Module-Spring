package com.check.template_methods.handlers;

import com.check.JWT.JwtTokenService;
import com.check.models.UserState;
import com.check.services.IUserService;
import com.check.services.state.IUserStateService;
import com.check.template_methods.DTO.RequestDTO;
import com.check.template_methods.UserTemplateMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserStateHandler extends UserTemplateMethod implements UserStateHandler {
    @Autowired
    private IUserStateService userStateService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IUserService userService;
    public GetUserStateHandler() {
        super();
    }

    @Override
    protected void getUserState(RequestDTO request) {
        Optional<UserState> userState = userStateService.getUserStateByUserId(request.getUserId());
        if(userState.isEmpty()) request.setMessage("User State not found");
        else request.getMap().put(request.getMessage(), userState.get());
    }

    @Override
    protected void createMessageResponse(RequestDTO request) {}

    @Override
    public UserStateChain handler(RequestDTO request) {
        if(request.getMessage().contains("null"))
            getUserState(request);
        return new UserStateChain(this);
    }
}
