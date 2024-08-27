package com.check.mapper;

import com.check.DTO.CheckInOutput;
import com.check.DTO.CheckOutOutput;
import com.check.models.User;
import com.check.models.WorkHour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
//@Component
public interface WorkHourMapper {
    WorkHourMapper INSTANCE = Mappers.getMapper(WorkHourMapper.class);

//    @Mapping(source = "workHour.start", target = "start")
//    @Mapping(source = "user.employeeCode", target = "employeeCode")
//    @Mapping(source = "workHour.status", target = "status")
    CheckInOutput workHourToCheckInOutPut(WorkHour workHour, User user);

//    @Mapping(source = "workHour.start", target = "start")
//    @Mapping(source = "workHour.end", target = "end")
//    @Mapping(source = "user.employeeCode", target = "employeeCode")
//    @Mapping(source = "workHour.status", target = "status")
//    @Mapping(source = "workHour.note", target = "note")
    CheckOutOutput workHourToCheckOutOutput(WorkHour workHour, User user);
}
