package com.check.services.impl;

import com.check.models.UserState;
import com.check.repositories.JPARepository.UserStateRepository;
import com.check.services.IUserStateService;
import com.check.state_dp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserStateServiceImpl implements IUserStateService {
    @Autowired
    private UserStateRepository userStateRepository;
    @Override
    public IUserState handle(UserState userState) {
        IUserState iUserState;
        switch (userState.getState()) {
            case RECRUITMENT -> {
                iUserState = new RecruitmentState();
            }
            case TRAINING -> {
                iUserState = new TrainingState();
            }
            case EVALUATION -> {
                iUserState = new EvaluationState();
            }
            case PROMOTION -> {
                iUserState = new PromotionState();
            }
            default -> iUserState = null;
        }
        return iUserState;
    }

    @Override
    public UserState getUserStateById(int id) {
        return userStateRepository.findById(id).orElse(null);
    }
}
