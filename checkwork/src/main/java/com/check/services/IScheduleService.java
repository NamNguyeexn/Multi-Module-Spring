package com.check.services;

import com.check.DTO.ScheduleOutput;
import com.check.models.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IScheduleService {
    List<ScheduleOutput> getSchedulesByHost(int hostid);
    List<ScheduleOutput> getSchedulesByJoin(int joinid);
    void save(Schedule schedule);
}
