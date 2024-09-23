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
public class TrainingState implements IUserState{
    @Autowired
    private IUserService userService;
    @Override
    public long getSalaryByHour(UserState userState) {
        userState.setSalaryByHour(userState.getSalaryByHour() + 10000);
        return userState.getSalaryByHour();
    }

    @Override
    public Map<String, User> getState(UserState userState) {
        Optional<User> user = userService.getUserById(userState.getUserid());
        return user.map(value -> Map.of(userState.getState().toString(), value)).orElse(null);
    }

    @Override
    public void promote(UserState userState) {
        userState.setState(State.EVALUATION);
    }

    @Override
    public void demote(UserState userState) {
        userState.setState(State.RECRUITMENT);
    }
}
