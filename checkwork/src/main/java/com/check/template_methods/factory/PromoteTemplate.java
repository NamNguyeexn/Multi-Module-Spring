//package com.check.template_methods.factory;
//
//import com.check.models.UserState;
//import com.check.services.state.IUserStateService;
//import com.check.template_methods.DTO.RequestDTO;
//import com.check.template_methods.UserTemplateMethod;
//import com.check.template_methods.handlers.UserStateHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//@Component
//public class PromoteTemplate extends UserTemplateMethod{
//    @Autowired
//    private IUserStateService userStateService;
//    @Override
//    protected void getUserState(RequestDTO request) {
//        Optional<UserState> userState = userStateService.getUserStateByUserId(request.getUserId());
//        if(userState.isEmpty()) request.setMessage("User State not found");
//        else request.getMap().put(request.getMessage(), userState.get());
//    }
//
//    @Override
//    protected void createMessageResponse(RequestDTO request) {
//        if(!request.getMessage().contains("USER") || !request.getMap().isEmpty()) {
//            request.setMessage("Got error");
//        }
//        else {
//            request.setMessage("Congratulation! You have been promoted! " +
//                    "Let's try more and more to have a bigger success in the future");
//        }
//    }
//
//}
