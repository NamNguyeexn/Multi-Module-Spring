package com.check.batch;

import com.check.models.Schedule;
import com.check.repositories.JPARepository.ScheduleRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBWriter implements ItemWriter<Schedule> {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void write(Chunk<? extends Schedule> chunk) throws Exception {
        System.out.println("Data Saved for Users: " + chunk);
        scheduleRepository.saveAll(chunk);
    }
}
