package com.check.dto.iterator;

import com.check.models.Schedule;
import com.check.repositories.JPARepository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleByDay implements IScheduleListFactory{
    private final ScheduleRepository scheduleRepository;

    public ScheduleByDay(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleList createScheduleList() {
        ScheduleList scheduleList = new ScheduleList();
        List<Schedule> list = scheduleRepository.findAll();
        list.stream()
                .filter(s -> s.getStart().getDayOfYear() == LocalDate.now().getDayOfYear())
                .forEach(scheduleList::addSchedule);
        return scheduleList;
    }
}
