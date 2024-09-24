package com.check.iterators;

import com.check.models.Schedule;

public interface IScheduleIterator {
    public boolean hasNext();
    public Schedule next();
}
