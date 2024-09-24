package com.check.batch.steps.writers;

import com.check.models.Schedule;
import com.check.repositories.JPARepository.ScheduleRepository;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ScheduleWriter {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Bean
    public RepositoryItemWriter<Schedule> getWriter() {
        RepositoryItemWriter<Schedule> writer = new RepositoryItemWriter<>();
        writer.setRepository(scheduleRepository);
        writer.setMethodName("save");
        return writer;
    }
}
