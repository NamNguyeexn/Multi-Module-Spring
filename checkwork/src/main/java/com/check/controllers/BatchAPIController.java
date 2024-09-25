package com.check.controllers;

import com.check.batch.jobs.JobPerEvaluation;
import com.check.batch.jobs.JobSchedule;
import com.check.batch.jobs.JobUserState;
import com.check.batch.steps.AppointmentToScheduleStep;
import com.check.batch.steps.UserStateToUserStep;
import com.check.batch.steps.WorkHourToPerEvaluationStep;
import com.check.validations.batch.ValidDataTypeBatch;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/batch")
@EnableAsync(proxyTargetClass = true)
@Slf4j
public class BatchAPIController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobSchedule jobSchedule;
    @Autowired
    private JobUserState jobUserState;
    @Autowired
    private JobPerEvaluation jobPerEvaluation;
    @GetMapping("")
    @Async("BatchExecutor")
    public void loadAppointment(@ValidDataTypeBatch @RequestParam("data") String data) throws Exception {
        Map<String, JobParameter<?>> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis(), JobParameter.class));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = switch (data) {
            case "schedule" -> jobLauncher.run(jobSchedule.getJob(), parameters);
            case "userstate" -> jobLauncher.run(jobUserState.getJob(), parameters);
            case "perevaluation" -> jobLauncher.run(jobPerEvaluation.getJob(), parameters);
            default -> null;
        };
        String message = "Batch Status : ";
        if (jobExecution == null) message += "No job execution found";
        else message += jobExecution.getStatus();
        log.info(message);
    }

}
