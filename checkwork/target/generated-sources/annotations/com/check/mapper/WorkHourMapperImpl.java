package com.check.mapper;

import com.check.DTO.CheckInOutput;
import com.check.DTO.CheckOutOutput;
import com.check.models.User;
import com.check.models.WorkHour;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T00:04:12+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class WorkHourMapperImpl implements WorkHourMapper {

    @Override
    public CheckInOutput workHourToCheckInOutPut(WorkHour workHour, User user) {
        if ( workHour == null && user == null ) {
            return null;
        }

        CheckInOutput checkInOutput = new CheckInOutput();

        return checkInOutput;
    }

    @Override
    public CheckOutOutput workHourToCheckOutOutput(WorkHour workHour, User user) {
        if ( workHour == null && user == null ) {
            return null;
        }

        CheckOutOutput checkOutOutput = new CheckOutOutput();

        return checkOutOutput;
    }
}
