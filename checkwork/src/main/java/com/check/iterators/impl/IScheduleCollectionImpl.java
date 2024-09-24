package com.check.iterators.impl;

import com.check.iterators.IScheduleCollection;
import com.check.iterators.IScheduleIterator;
import com.check.models.ENUM.Type;
import com.check.models.Schedule;

import java.util.ArrayList;
import java.util.List;

public class IScheduleCollectionImpl  implements IScheduleCollection {
    private List<Schedule> schedules;
    public IScheduleCollectionImpl() {
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
    public IScheduleIterator iterator(Type type) {
        return new IScheduleIteratorImpl(type, this.schedules);
    }
}
