package com.check.services.state;

import com.check.models.UserState;
import com.check.state_dp.IUserState;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IUserStateService {
    IUserState handle(UserState userState);
    UserState getUserStateById(int id);
    void saveUserState(UserState userState);
    Optional<UserState> getUserStateByUserId(int userid);
}
