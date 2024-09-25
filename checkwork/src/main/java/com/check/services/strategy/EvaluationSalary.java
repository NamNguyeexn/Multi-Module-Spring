package com.check.services.strategy;

import com.check.models.PerEvaluation;
import com.check.models.UserState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationSalary implements ISalaryStrategy {
    @Override
    public Long calSalary(List<PerEvaluation> perEvaluation, UserState userState) {
        double efficiency = perEvaluation.get(0).getEfficiency();
        int count = perEvaluation.size();
        long salaryByHour = userState.getSalaryByHour();
        return (long) (salaryByHour * count * 8 * efficiency + 100000 * efficiency);
    }
}
