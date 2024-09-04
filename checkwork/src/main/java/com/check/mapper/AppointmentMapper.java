package com.check.mapper;

import com.check.DTO.AppointmentFormInput;
import com.check.DTO.AppointmentFormOutput;
import com.check.models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "joinid", target = "joinid")
//    @Mapping(source = "start", target = "start")
//    @Mapping(source = "end", target = "end")
//    @Mapping(source = "detail", target = "detail")
//    @Mapping(source = "type", target = "type")
//    AppointmentFormInput toAppointmentFormInput(Appointment appointment);

//    @Mapping(source = "appointmentFormInput.name", target = "name")
//    @Mapping(source = "appointmentFormInput.start", target = "start")
//    @Mapping(source = "appointmentFormInput.end", target = "end")
//    @Mapping(source = "appointmentFormInput.detail", target = "detail")
//    @Mapping(source = "appointmentFormInput.type", target = "type")
//    @Mapping(source = "hostName", target = "hostName")
//    @Mapping(source = "appointmentFormInput.joinid", target = "joinsName")
//    @Mapping(source = "info", target = "info")
//    @Mapping(source = "room", target = "room")
    AppointmentFormOutput toAppointmentFormOutput(AppointmentFormInput appointmentFormInput, String hostName, String info, String room);

//    @Mapping(source = "appointmentFormInput.name", target = "name")
//    @Mapping(source = "hostid", target = "hostid")
//    @Mapping(source = "joinid", target = "joinid")
//    @Mapping(source = "start", target = "start")
//    @Mapping(source = "end", target = "end")
//    @Mapping(source = "appointmentFormInput.detail", target = "detail")
//    @Mapping(source = "appointmentFormInput.type", target = "type")
//    @Mapping(source = "room", target = "room")
//    @Mapping(source = "info", target = "info")
    Appointment toAppointment(AppointmentFormInput appointmentFormInput, String joinid, int hostid, String info, String room, LocalDateTime start, LocalDateTime end);
}
