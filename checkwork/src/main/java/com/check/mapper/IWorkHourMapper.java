package com.check.mapper;

import com.check.dto.CheckInOutput;
import com.check.dto.CheckOutOutput;
import com.check.models.ENUM.Status;
import com.check.models.User;
import com.check.models.WorkHour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
//@Component
public interface IWorkHourMapper {
    IWorkHourMapper INSTANCE = Mappers.getMapper(IWorkHourMapper.class);

//    @Mapping(source = "start", target = "start")
//    @Mapping(source = "employeeCode", target = "employeeCode")
//    @Mapping(source = "status", target = "status")
    CheckInOutput toCheckInOutPut(String start, String employeeCode, Status status);

    @Mapping(source = "start", target = "start")
    @Mapping(source = "end", target = "end")
    @Mapping(source = "user.employeeCode", target = "employeeCode")
    @Mapping(source = "workHour.status", target = "status")
    @Mapping(source = "workHour.note", target = "note")
    CheckOutOutput toCheckOutOutput(WorkHour workHour, User user, String start, String end);
}
