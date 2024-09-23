package com.check.DTO.iterator;

import com.check.models.Schedule;

import java.util.Iterator;

public class ScheduleIterator implements Iterator<Schedule> {
    private int index = 0;
    private ScheduleList scheduleList;
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Schedule next() {
        return null;
    }
}
