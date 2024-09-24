package com.check.services.state;

import com.check.models.UserState;
import com.check.state_dp.IUserState;

public interface IUserStateService {
    IUserState handle(UserState userState);
    UserState getUserStateById(int id);
    void saveUserState(UserState userState);
    UserState getUserStateByUserId(int userid);
}
