package com.check.DTO.iterator;

import com.check.models.Schedule;
import com.check.repositories.JPARepository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleByMonth implements ScheduleListFactory{
    private final ScheduleRepository scheduleRepository;

    public ScheduleByMonth(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleList createScheduleList() {
        ScheduleList scheduleList = new ScheduleList();
        List<Schedule> list = scheduleRepository.findAll();
        list.stream()
                .filter(s -> s.getStart().getMonth() == LocalDate.now().getMonth())
                .forEach(scheduleList::addSchedule);
        return scheduleList;
    }
}
