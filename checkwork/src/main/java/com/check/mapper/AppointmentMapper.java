package com.check.mapper;

import com.check.DTO.AppointmentFormInput;
import com.check.DTO.AppointmentFormOutput;
import com.check.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "joinid", target = "joinid")
    @Mapping(source = "start", target = "start")
    @Mapping(source = "end", target = "end")
    @Mapping(source = "detail", target = "detail")
    @Mapping(source = "type", target = "type")
    AppointmentFormInput toAppointmentFormInput(Appointment appointment);

    @Mapping(source = "name", target = "appointmentFormInput.name")
    @Mapping(source = "start", target = "appointmentFormInput.start")
    @Mapping(source = "end", target = "appointmentFormInput.end")
    @Mapping(source = "detail", target = "appointmentFormInput.detail")
    @Mapping(source = "type", target = "appointmentFormInput.type")
    @Mapping(source = "hostName", target = "hostName")
    @Mapping(source = "joinName", target = "joinName")
    @Mapping(source = "info", target = "info")
    AppointmentFormOutput toAppointmentFormOutput(AppointmentFormInput appointmentFormInput, String hostName, String[] joinName, String info);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "hostid", target = "hostid")
    @Mapping(source = "joinid", target = "joinid")
    @Mapping(source = "start", target = "start")
    @Mapping(source = "end", target = "end")
    @Mapping(source = "detail", target = "detail")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "room", target = "room")
    @Mapping(source = "info", target = "info")
    Appointment toAppointment(AppointmentFormInput appointmentFormInput, String info, String room);
}
