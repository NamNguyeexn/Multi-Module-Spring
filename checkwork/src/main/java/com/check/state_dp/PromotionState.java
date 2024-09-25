package com.check.state_dp;

import com.check.models.ENUM.State;
import com.check.models.User;
import com.check.models.UserState;
import com.check.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
@Service
public class PromotionState implements IUserState{
    @Autowired
    private IUserService userService;
    @Override
    public void incrSalaryByHour(UserState userState) {
    }

    @Override
    public void decrSalaryByHour(UserState userState) {
        userState.setSalaryByHour(userState.getSalaryByHour()/2);
    }


    @Override
    public void promote(UserState userState) {

    }

    @Override
    public void demote(UserState userState) {
        decrSalaryByHour(userState);
        userState.setState(State.EVALUATION);
    }
}
