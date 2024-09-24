package com.check.batch.steps;

import com.check.batch.steps.processors.UserStateProcessor;
import com.check.batch.steps.readers.UserReader;
import com.check.batch.steps.writers.UserStateWriter;
import com.check.models.User;
import com.check.models.UserState;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class UserStateToUserStep {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private UserReader userReader;
    @Autowired
    private UserStateProcessor userStateProcessor;
    @Autowired
    private UserStateWriter userStateWriter;
    @Autowired
    private Executor executor;
    @Bean
    public Step getStep() throws Exception {
        return new StepBuilder("userState", jobRepository)
                .<User, UserState>chunk(1000, platformTransactionManager)
                .reader(userReader.getReader())
                .processor(userStateProcessor)
                .writer(userStateWriter.getWriter())
                .taskExecutor(executor.getExecutor())
                .build();
    }
}
