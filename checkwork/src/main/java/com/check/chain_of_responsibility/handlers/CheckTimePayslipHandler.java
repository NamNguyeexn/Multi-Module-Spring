package com.check.chain_of_responsibility.handlers;

import com.check.chain_of_responsibility.models.Payslip;

public class CheckTimePayslipHandler extends PayslipHandler {

    @Override
    protected double getConfirmableLimit() {
        return 10000;
    }

    @Override
    protected String getRole() {
        return "Check Time Pay Slip";
    }
}
