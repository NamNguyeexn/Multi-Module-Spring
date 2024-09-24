package com.check.DTO.iterator;

import com.check.models.Schedule;
import com.check.repositories.JPARepository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleByWeek implements IScheduleListFactory{

    private final ScheduleRepository scheduleRepository;

    public ScheduleByWeek(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleList createScheduleList() {
        List<Schedule> list = scheduleRepository.findAll();
        ScheduleList schedules = new ScheduleList();
        LocalDate start = LocalDate.now().minusDays(getWeek(LocalDate.now().getDayOfWeek().toString()));
        LocalDate end = start.plusDays(6);
        for(LocalDate date = start; date.isBefore(end) || date.isEqual(end); date = date.plusDays(1)) {
            LocalDate finalDate = date;
            list.stream()
                    .filter(s -> s.getStart().toLocalDate().isEqual(finalDate))
                    .forEach(schedules::addSchedule);
        }
        return schedules;
    }

    private static int getWeek(String s) {
        Map<String, Integer> list = new HashMap<>();
        list.put("MONDAY", 0);
        list.put("TUESDAY", 1);
        list.put("WEDNESDAY", 2);
        list.put("THURSDAY", 3);
        list.put("FRIDAY", 4);
        list.put("SATURDAY", 5);
        list.put("SUNDAY", 6);
        return list.getOrDefault(s, 0);
    }
}
