package com.check.services.strategy;

import com.check.models.PerEvaluation;

import java.util.List;

public interface ISalaryStrategy {
    Long calSalary(List<PerEvaluation> perEvaluation);
}
