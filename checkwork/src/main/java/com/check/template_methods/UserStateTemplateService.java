package com.check.template_methods;

import com.check.JWT.JwtTokenService;
import com.check.services.IUserService;
import com.check.template_methods.DTO.RequestDTO;
import com.check.template_methods.handlers.UserStateChain;
import com.check.template_methods.handlers.UserStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStateTemplateService extends UserTemplateMethod {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserStateChain chain;

    public void processes(RequestDTO request) {
        UserTemplateMethod userTemplateMethod = new UserStateTemplateService();
        userTemplateMethod.process(request, chain);
    }

    @Override
    protected void getUserState(RequestDTO request) {
    }

    @Override
    protected void createMessageResponse(RequestDTO request) {
    }
}
