package com.check.chain_of_responsibility.handlers;

import com.check.chain_of_responsibility.models.Payslip;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public abstract class PayslipHandler {
    protected PayslipHandler payslipHandler;

    abstract protected double getConfirmableLimit();
    abstract protected String getRole();
    public void setSuccessor(PayslipHandler payslipHandler){
        this.payslipHandler = payslipHandler;
    }
    public void handleRequest(double creditAmount){
        if(getConfirmableLimit() > creditAmount){
            log.info("\nApproved : " + creditAmount + ", role : " + getRole());
        } else {
            payslipHandler.handleRequest(creditAmount);
        }
    }
}
