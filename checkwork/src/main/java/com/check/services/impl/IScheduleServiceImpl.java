package com.check.services.impl;

import com.check.DTO.ScheduleOutput;
import com.check.adapters.ScheduleAdapter;
import com.check.mapper.ScheduleMapper;
import com.check.models.Appointment;
import com.check.models.Schedule;
import com.check.repositories.JPARepository.ScheduleRepository;
import com.check.services.IAppointmentService;
import com.check.services.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IScheduleServiceImpl implements IScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ScheduleAdapter scheduleAdapter;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private IAppointmentService appointmentService;
    @Override
    public List<ScheduleOutput> getSchedulesByHost(int hostid) {
        String hostname = scheduleAdapter.toHostname(hostid);
        List<ScheduleOutput> scheduleOutputs = new ArrayList<>();
        Optional<List<Appointment>> appointments = appointmentService.getAppointmentsByHostId(hostid);
        if (appointments.isEmpty()){
            return null;
        } else {
            for(Appointment a : appointments.get()){
                String joinnames = scheduleAdapter.toJoinsname(a.getJoinid());
                String start = a.getStart().toString();
                String end = a.getEnd().toString();
                Schedule schedule = Schedule.builder()
                        .hostname(hostname)
                        .joinname(joinnames)
                        .start(a.getStart())
                        .end(a.getEnd())
                        .type(a.getType())
                        .detail(a.getDetail())
                        .build();
                scheduleOutputs.add(scheduleMapper.toScheduleOutput(schedule, joinnames.split(","), start, end));
            }
            return scheduleOutputs;
        }
    }

    @Override
    public List<ScheduleOutput> getSchedulesByJoin(int joinid) {
        List<ScheduleOutput> scheduleOutputs = new ArrayList<>();
        Optional<List<Appointment>> appointments = appointmentService.getAppointmentsByJoinId(joinid);
        if(appointments.isEmpty()){
            return null;
        } else {
            for(Appointment a : appointments.get()){
                String hostname = scheduleAdapter.toHostname(a.getHostid());
                String joinnames = scheduleAdapter.toJoinsname(a.getJoinid());
                String start = a.getStart().toString();
                String end = a.getEnd().toString();
                Schedule schedule = scheduleMapper.toSchedule(a, hostname, joinnames, start, end);
                scheduleOutputs.add(scheduleMapper.toScheduleOutput(schedule, joinnames.split(","), start, end));
            }
            return scheduleOutputs;
        }
    }
    @Override
    public void save(Schedule schedule){
        scheduleRepository.save(schedule);
    }

}
