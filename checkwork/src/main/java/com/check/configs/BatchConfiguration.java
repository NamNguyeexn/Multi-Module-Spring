package com.check.configs;

import com.check.batch.steps.AppointmentToScheduleStep;
import com.check.batch.steps.UserStateToUserStep;
import com.check.batch.steps.WorkHourToPerEvaluationStep;
import com.common.configs.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import({DatabaseConfig.class})
public class BatchConfiguration {
    @Autowired
    public AppointmentToScheduleStep appointmentToScheduleStep;
    @Autowired
    private UserStateToUserStep userStateToUserStep;
    @Autowired
    private WorkHourToPerEvaluationStep workHourToPerEvaluationStep;
}