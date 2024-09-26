package com.check.template_methods;

import com.check.models.UserState;
import com.check.services.state.IUserStateService;
import com.check.template_methods.DTO.RequestDTO;
import com.check.template_methods.handlers.UserStateChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserStateTemplateService extends UserTemplateMethod {
    @Autowired
    private IUserStateService userStateService;
    @Autowired
    private UserStateChain chain;

    public void processes(RequestDTO request) {
        UserTemplateMethod userTemplateMethod = new UserStateTemplateService();
        Optional<UserState> userState = userStateService.getUserStateByUserId(request.getUserId());
        if (userState.isEmpty()) {request.setMessage("User State not found");}
        request.setUserState(userState.get());
        userTemplateMethod.process(request, chain);
    }

    @Override
    public void getUserState(RequestDTO request) {
    }

    @Override
    public void createMessageResponse(RequestDTO request) {
    }
}
