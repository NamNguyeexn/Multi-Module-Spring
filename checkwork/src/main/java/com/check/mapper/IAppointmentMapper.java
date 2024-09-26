package com.check.mapper;

import com.check.dto.AppointmentFormInput;
import com.check.dto.AppointmentFormOutput;
import com.check.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface IAppointmentMapper {
    IAppointmentMapper INSTANCE = Mappers.getMapper(IAppointmentMapper.class);

    @Mapping(source = "appointmentFormInput.name", target = "name")
    @Mapping(source = "appointmentFormInput.start", target = "start")
    @Mapping(source = "appointmentFormInput.end", target = "end")
    @Mapping(source = "appointmentFormInput.detail", target = "detail")
    @Mapping(source = "appointmentFormInput.type", target = "type")
    @Mapping(source = "hostName", target = "hostName")
    @Mapping(source = "appointmentFormInput.joinid", target = "joinsName")
    @Mapping(source = "info", target = "info")
    @Mapping(source = "room", target = "room")
    AppointmentFormOutput toAppointmentFormOutput(AppointmentFormInput appointmentFormInput, String hostName, String info, String room);

    @Mapping(source = "appointmentFormInput.name", target = "name")
    @Mapping(source = "hostid", target = "hostid")
    @Mapping(source = "joinid", target = "joinid")
    @Mapping(source = "start", target = "start")
    @Mapping(source = "end", target = "end")
    @Mapping(source = "appointmentFormInput.detail", target = "detail")
    @Mapping(source = "appointmentFormInput.type", target = "type")
    @Mapping(source = "room", target = "room")
    @Mapping(source = "info", target = "info")
    Appointment toAppointment(AppointmentFormInput appointmentFormInput, String joinid, int hostid, String info, String room, LocalDateTime start, LocalDateTime end);
}
