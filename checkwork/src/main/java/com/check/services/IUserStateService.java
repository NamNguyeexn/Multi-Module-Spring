package com.check.services;

import com.check.models.UserState;
import com.check.state_dp.IUserState;

public interface IUserStateService {
    IUserState handle(UserState userState);
    UserState getUserStateById(int id);
    void saveUserState(UserState userState);
}
