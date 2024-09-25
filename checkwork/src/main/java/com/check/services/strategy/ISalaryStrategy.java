package com.check.services.strategy;

import com.check.models.PerEvaluation;
import com.check.models.UserState;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISalaryStrategy {
    Long calSalary(List<PerEvaluation> perEvaluation, UserState userState);
}
