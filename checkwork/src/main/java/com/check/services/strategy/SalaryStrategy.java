package com.check.services.strategy;

import com.check.models.PerEvaluation;
import com.check.models.UserState;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
public class SalaryStrategy{
    private ISalaryStrategy salaryStrategy;
    public long executeSalary(List<PerEvaluation> perEvaluation, UserState userState){
        return salaryStrategy.calSalary(perEvaluation, userState);
    }
}
