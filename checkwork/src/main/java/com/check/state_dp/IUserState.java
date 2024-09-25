package com.check.state_dp;

import com.check.models.UserState;


public interface IUserState {
    void incrSalaryByHour(UserState userState);
    void decrSalaryByHour(UserState userState);
    void promote(UserState userState);
    void demote(UserState userState);
}
