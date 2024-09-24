package com.check.services.strategy;

import com.check.models.PerEvaluation;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Component
public class SalaryStrategy{
    private ISalaryStrategy salaryStrategy;
    public long executeSalary(List<PerEvaluation> perEvaluation){
        return salaryStrategy.calSalary(perEvaluation);
    }
}
