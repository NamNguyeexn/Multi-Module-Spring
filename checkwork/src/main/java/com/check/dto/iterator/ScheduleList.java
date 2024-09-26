package com.check.dto.iterator;

import com.check.models.Schedule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScheduleList implements Iterable<Schedule> {
    private List<Schedule> scheduleList = new ArrayList<>();
    public void addSchedule(Schedule schedule) {
        scheduleList.add(schedule);
    }
    @Override
    public Iterator<Schedule> iterator() {
        return scheduleList.iterator();
    }
}
