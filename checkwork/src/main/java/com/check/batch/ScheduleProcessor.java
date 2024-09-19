package com.check.batch;

import com.check.adapters.ScheduleAdapter;
import com.check.models.Appointment;
import com.check.models.Schedule;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleProcessor implements ItemProcessor<AppointmentBatch, Schedule> {
    @Autowired
    private ScheduleAdapter scheduleAdapter;
    @Override
    public Schedule process(AppointmentBatch item) throws Exception {
        final String hostname = scheduleAdapter.toHostname(item.getHostid());
        final String joinname = scheduleAdapter.toJoinsname(item.getJoinid());
        System.out.printf("Converted from [%s] to [%s]%n", item.getHostid(), hostname);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.S");
        return Schedule.builder()
                .hostname(hostname)
                .joinname(joinname)
                .start(LocalDateTime.parse(item.getStart(), formatter))
                .end(LocalDateTime.parse(item.getEnd(), formatter))
                .type(item.getType())
                .detail(item.getDetail())
                .build();
    }
}
