package com.check.batch.jobs;

import com.check.batch.steps.UserStateToUserStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
public class JobUserState {
    @Autowired
    private UserStateToUserStep userStateToUserStep;
    @Autowired
    private JobRepository jobRepository;

    @Bean
    public Job getJob() throws Exception {
        return new JobBuilder("importUserStates", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(userStateToUserStep.getStep())
                .build();
    }
}
