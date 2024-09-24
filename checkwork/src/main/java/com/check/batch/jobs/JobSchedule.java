package com.check.batch.jobs;

import com.check.batch.steps.AppointmentToScheduleStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobSchedule {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private AppointmentToScheduleStep appointmentToScheduleStep;
    public Job getJob() {
        return new JobBuilder("Import Schedule", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(appointmentToScheduleStep.getStep())
                .build();
    }

}
