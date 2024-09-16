package com.check.chain_of_responsibility.handlers;

import com.check.chain_of_responsibility.services.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserPayslipHandler extends PayslipHandler {

    @Override
    protected double getConfirmableLimit() {
        return 1000;
    }

    @Override
    protected String getRole() {
        return "User Pay Slip";
    }
}
