package com.check.template_methods;

import com.check.JWT.JwtTokenService;
import com.check.models.User;
import com.check.models.UserState;
import com.check.services.IUserService;
import com.check.template_methods.DTO.RequestDTO;
//import com.check.template_methods.factory.DemoteTemplate;
//import com.check.template_methods.factory.GetSalaryTemplate;
//import com.check.template_methods.factory.GetUserStateTemplate;
//import com.check.template_methods.factory.PromoteTemplate;
import com.check.template_methods.handlers.CreateMessageResponse;
import com.check.template_methods.handlers.GetUserStateHandler;
import com.check.template_methods.handlers.UserStateChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public abstract class UserTemplateMethod {

    public void process(RequestDTO request, UserStateChain chain) {
//        getUser(request);
        createMapResponse(request);
        chain.setHandlers(new GetUserStateHandler())
                .setHandlers(new CreateMessageResponse());
        chain.handlers(request);
    }

    //    protected void getUser(RequestDTO request){
//        request.setMessage(request.getMessage()));
//    }
    protected void createMapResponse(RequestDTO request) {
        if (!request.getMessage().contains("USER")) {
            request.setMessage("not found");
        } else {
            Map<String, UserState> m = new HashMap<>();
            request.setMap(m);
            request.setMessage("null");//meanwhile it's not fail
        }
    }

    protected abstract void getUserState(RequestDTO request);

    protected abstract void createMessageResponse(RequestDTO request);
//    protected static UserTemplateMethod createUserStateService(RequestDTO request, String response){
//        switch (request.getRequestType()){
//            case GetUserState -> {
//                return new GetUserStateTemplate();
//            }
//            case Promote -> {
//                return new PromoteTemplate();
//            }
//            case Demote -> {
//                return new DemoteTemplate();
//            }
//            case GetSalary -> {
//                return new GetSalaryTemplate();
//            }
//            default ->
//                    throw new IllegalStateException("Unexpected value: " + request.getRequestType());
//        }
//    }
}
