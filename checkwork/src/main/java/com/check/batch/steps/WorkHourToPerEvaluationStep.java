package com.check.batch.steps;

import com.check.batch.DTO.WorkHourBatch;
import com.check.batch.steps.processors.WorkHourProcessor;
import com.check.batch.steps.readers.WorkHourReader;
import com.check.batch.steps.writers.PerEvaluationWriter;
import com.check.models.PerEvaluation;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class WorkHourToPerEvaluationStep {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private WorkHourReader workHourReader;
    @Autowired
    private WorkHourProcessor workHourProcessor;
    @Autowired
    private PerEvaluationWriter perEvaluationWriter;
    @Autowired
    private Executor executor;
    @Bean
    public Step getStep() throws Exception {
        return new StepBuilder("userState", jobRepository)
                .<WorkHourBatch, PerEvaluation>chunk(1000, platformTransactionManager)
                .reader(workHourReader.getReader())
                .processor(workHourProcessor)
                .writer(perEvaluationWriter.getWriter())
                .taskExecutor(executor.getExecutor())
                .build();
    }
}
