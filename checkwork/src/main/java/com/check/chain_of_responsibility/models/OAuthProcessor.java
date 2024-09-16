package com.check.chain_of_responsibility.models;

public class OAuthProcessor extends AuthenticationProcessor{
    public OAuthProcessor(AuthenticationProcessor nextProcessor){
        super(nextProcessor);
    }
    @Override
    public boolean isAuthorized(AuthenticationProcessor authProcessor) {
        if (authProcessor instanceof OAuthProcessor) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProcessor);
        }
        return false;
    }
}
