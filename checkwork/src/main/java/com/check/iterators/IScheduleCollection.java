package com.check.iterators;

import com.check.models.ENUM.Type;
import com.check.models.Schedule;

public interface IScheduleCollection {
    void addSchedule(Schedule schedule);
    void removeSchedule(Schedule schedule);
    IScheduleIterator iterator(Type type);
}
