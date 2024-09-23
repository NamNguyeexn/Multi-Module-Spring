package com.check.state_dp;

import com.check.models.User;
import com.check.models.UserState;

import java.util.Map;

public interface IUserState {
    long getSalaryByHour(UserState userState);
    Map<String, User> getState(UserState userState);
    void promote(UserState userState);
    void demote(UserState userState);
}
