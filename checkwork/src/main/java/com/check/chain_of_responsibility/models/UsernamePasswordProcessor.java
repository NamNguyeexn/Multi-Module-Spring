package com.check.chain_of_responsibility.models;

import com.check.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernamePasswordProcessor extends AuthenticationProcessor{
    @Autowired
    private IUserService userService;
    public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }
    @Override
    public boolean isAuthorized(AuthenticationProcessor authProcessor) {
        if (authProcessor instanceof UsernamePasswordProcessor) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProcessor);
        }
        return false;
    }
}
