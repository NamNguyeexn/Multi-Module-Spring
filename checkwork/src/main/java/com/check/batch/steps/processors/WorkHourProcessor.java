package com.check.batch.steps.processors;

import com.check.batch.DTO.WorkHourBatch;
import com.check.models.PerEvaluation;
import com.check.models.UserState;
import com.check.services.state.IUserStateService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkHourProcessor implements ItemProcessor<WorkHourBatch, PerEvaluation> {
    @Autowired
    private IUserStateService userStateService;
    @Override
    public PerEvaluation process(WorkHourBatch item) throws Exception {
        UserState userState = userStateService.getUserStateByUserId(item.getUserid());
        return PerEvaluation.builder()
                .workhourid(item.getId())
                .userstateid(userState.getId())
                .build();
    }
}
