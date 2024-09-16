package com.check.services.handlers.workhour;

import com.check.models.WorkHour;

public interface WorkHourHandler {
    void handleRequest(WorkHour workHour);
    void setNextHandler(WorkHourHandler workHourHandler);
}
