package com.check.services.strategy;

import com.check.models.PerEvaluation;
import com.check.models.UserState;
import com.check.services.IPerEvaluationService;
import com.check.services.state.IUserStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainingSalary implements ISalaryStrategy {
    @Autowired
    private IUserStateService userStateService;
    @Autowired
    private IPerEvaluationService perEvaluationService;
    @Override
    public Long calSalary(List<PerEvaluation> perEvaluation) {
        UserState userState = userStateService.getUserStateById(perEvaluation.get(0).getUserstateid());
        double efficiency = perEvaluation.get(0).getEfficiency();
        int count = perEvaluation.size();
        long salaryByHour = userState.getSalaryByHour();
        return (long) (salaryByHour * count * efficiency + 50000 * efficiency);
    }
}
