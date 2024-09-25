package com.check.batch.steps.processors;

import com.check.models.PerEvaluation;
import com.check.models.UserState;
import com.check.models.WorkHour;
import com.check.services.IPerEvaluationService;
import com.check.services.state.IUserStateService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WorkHourProcessor implements ItemProcessor<WorkHour, PerEvaluation> {
    @Autowired
    private IUserStateService userStateService;
    @Autowired
    private IPerEvaluationService perEvaluationService;

    @Override
    public PerEvaluation process(WorkHour item) {
        Optional<UserState> userState = userStateService.getUserStateByUserId(item.getUserid());
        if (perEvaluationService.checkIfWorkHourExists(item.getId())) return null;
        return userState.map(state -> PerEvaluation.builder()
                .workhourid(item.getId())
                .userstateid(state.getId())
                .build()).orElse(null);
    }
}
