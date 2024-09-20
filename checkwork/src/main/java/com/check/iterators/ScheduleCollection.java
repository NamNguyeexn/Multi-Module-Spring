package com.check.iterators;

import com.check.models.ENUM.Type;
import com.check.models.Schedule;

public interface ScheduleCollection {
    void addSchedule(Schedule schedule);
    void removeSchedule(Schedule schedule);
    ScheduleIterator iterator(Type type);
}
