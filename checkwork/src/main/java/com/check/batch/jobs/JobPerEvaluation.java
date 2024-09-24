package com.check.batch.jobs;

import com.check.batch.steps.WorkHourToPerEvaluationStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JobPerEvaluation {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private WorkHourToPerEvaluationStep workHourToPerEvaluationStep;

    @Bean
    public Job getJob() throws Exception {
        return new JobBuilder("importPreEvaluations", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(workHourToPerEvaluationStep.getStep())
                .build();
    }
}
