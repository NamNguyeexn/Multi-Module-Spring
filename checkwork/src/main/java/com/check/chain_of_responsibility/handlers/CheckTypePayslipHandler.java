package com.check.chain_of_responsibility.handlers;

public class CheckTypePayslipHandler extends PayslipHandler{
    @Override
    protected double getConfirmableLimit() {
        return 20000;
    }

    @Override
    protected String getRole() {
        return "Check Type Pay Slip";
    }
}
