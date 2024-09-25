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
public class RecruitmentState implements IUserState{
    @Autowired
    private IUserService userService;
    @Override
    public void incrSalaryByHour(UserState userState) {
        userState.setSalaryByHour(userState.getSalaryByHour() + 10000);
    }

    @Override
    public void decrSalaryByHour(UserState userState) {

    }


    @Override
    public void promote(UserState userState) {
        incrSalaryByHour(userState);
        userState.setState(State.TRAINING);
    }

    @Override
    public void demote(UserState userState) {

    }
}
