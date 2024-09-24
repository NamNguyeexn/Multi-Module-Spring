package com.check.batch.steps;

import com.check.batch.DTO.AppointmentBatch;
import com.check.batch.steps.processors.ScheduleProcessor;
import com.check.batch.steps.readers.AppointmentReader;
import com.check.batch.steps.writers.ScheduleWriter;
import com.check.models.Schedule;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AppointmentToScheduleStep {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private AppointmentReader appointmentReader;
    @Autowired
    private ScheduleProcessor scheduleProcessor;
    @Autowired
    private ScheduleWriter scheduleWriter;
    @Autowired
    private Executor executor;
    @Bean
    public Step getStep() {
        return new StepBuilder("appointments", jobRepository)
                .<AppointmentBatch, Schedule>chunk(1000, platformTransactionManager)
                .reader(appointmentReader.getReader())
                .processor(scheduleProcessor)
                .writer(scheduleWriter.getWriter())
                .taskExecutor(executor.getExecutor())
                .build();
    }
}
