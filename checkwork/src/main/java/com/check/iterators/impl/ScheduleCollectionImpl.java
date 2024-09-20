package com.check.iterators.impl;

import com.check.iterators.ScheduleCollection;
import com.check.iterators.ScheduleIterator;
import com.check.models.ENUM.Type;
import com.check.models.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleCollectionImpl  implements ScheduleCollection {
    private List<Schedule> schedules;
    public ScheduleCollectionImpl() {
        this.schedules = new ArrayList<>();
    }
    @Override
    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void removeSchedule(Schedule schedule) {
        this.schedules.remove(schedule);
    }

    @Override
    public ScheduleIterator iterator(Type type) {
        return new ScheduleIteratorImpl(type, this.schedules);
    }
}
