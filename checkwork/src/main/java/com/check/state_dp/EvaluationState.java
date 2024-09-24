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
public class EvaluationState implements IUserState{
    @Autowired
    private IUserService userService;
    @Override
    public void getSalaryByHour(UserState userState) {
        userState.setSalaryByHour(userState.getSalaryByHour() + 20000);
    }

    @Override
    public Map<String, User> getState(UserState userState) {
        Optional<User> user = userService.getUserById(userState.getUserid());
        getSalaryByHour(userState);
        return user.map(value -> Map.of(userState.getState().toString(), value)).orElse(null);
    }

    @Override
    public void promote(UserState userState) {
        userState.setState(State.PROMOTION);
    }

    @Override
    public void demote(UserState userState) {
        userState.setState(State.TRAINING);
    }
}
