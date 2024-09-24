package com.check.mapper;

import com.check.DTO.ScheduleOutput;
import com.check.adapters.IScheduleAdapter;
import com.check.models.Appointment;
import com.check.models.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface IScheduleMapper {
    IScheduleAdapter INSTANCE = Mappers.getMapper(IScheduleAdapter.class);

    @Mapping(source = "schedule.hostname", target = "hostname")
    @Mapping(source = "joinnames", target = "joinname")
    @Mapping(source = "start", target = "start")
    @Mapping(source = "end", target = "end")
    @Mapping(source = "schedule.type", target = "type")
    @Mapping(source = "schedule.detail", target = "detail")
    ScheduleOutput toScheduleOutput(Schedule schedule, String[] joinnames, String start, String end);

    @Mapping(source = "start", target = "start")
    @Mapping(source = "end", target = "end")
    @Mapping(source = "appointment.type", target = "type")
    @Mapping(source = "appointment.detail", target = "detail")
    @Mapping(source = "hostname", target = "hostname")
    @Mapping(source = "joinnames", target = "joinname")
    Schedule toSchedule(Appointment appointment, String hostname, String joinnames, String start, String end);
}
