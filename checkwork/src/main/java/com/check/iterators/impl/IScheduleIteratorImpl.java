package com.check.iterators.impl;

import com.check.iterators.IScheduleIterator;
import com.check.models.ENUM.Type;
import com.check.models.Schedule;

import java.util.List;

public class IScheduleIteratorImpl implements IScheduleIterator {
    private Type type;
    private List<Schedule> schedules;
    private int index;

    public IScheduleIteratorImpl(Type type, List<Schedule> schedules) {
        this.type = type;
        this.schedules = schedules;
    }

    @Override
    public boolean hasNext() {
        for (Schedule schedule : schedules) {
            if(schedule.getType().equals(type) || type.equals(Type.OFFLINE)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Schedule next() {
        Schedule s = schedules.get(index);
        index++;
        return s;
    }
}
