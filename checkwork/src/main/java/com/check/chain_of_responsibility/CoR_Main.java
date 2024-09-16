package com.check.chain_of_responsibility;

import com.check.chain_of_responsibility.handlers.CheckTimePayslipHandler;
import com.check.chain_of_responsibility.handlers.CheckTypePayslipHandler;
import com.check.chain_of_responsibility.handlers.UserPayslipHandler;

public class CoR_Main {
    public static void main(String[] args) {
        UserPayslipHandler userPayslipHandler = new UserPayslipHandler();
        CheckTypePayslipHandler checkTypePayslipHandler = new CheckTypePayslipHandler();
        CheckTimePayslipHandler checkTimePayslipHandler = new CheckTimePayslipHandler();

        userPayslipHandler.setSuccessor(checkTimePayslipHandler);
        checkTimePayslipHandler.setSuccessor(checkTypePayslipHandler);

        double credit = 1900;
        userPayslipHandler.handleRequest(credit);
    }
}
