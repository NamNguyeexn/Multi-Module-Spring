package com.check.mapper;

import com.check.DTO.CheckInOutput;
import com.check.DTO.CheckOutOutput;
import com.check.models.User;
import com.check.models.WorkHour;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T16:24:19+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class WorkHourMapperImpl implements WorkHourMapper {

    @Override
    public CheckInOutput workHourToCheckInOutPut(WorkHour workHour, User user) {
        if ( workHour == null && user == null ) {
            return null;
        }

        CheckInOutput checkInOutput = new CheckInOutput();

        if ( workHour != null ) {
            checkInOutput.setStart( workHour.getStart() );
            checkInOutput.setStatus( workHour.getStatus() );
        }
        if ( user != null ) {
            checkInOutput.setEmployeeCode( user.getEmployeeCode() );
        }

        return checkInOutput;
    }

    @Override
    public CheckOutOutput workHourToCheckOutOutput(WorkHour workHour, User user) {
        if ( workHour == null && user == null ) {
            return null;
        }

        CheckOutOutput checkOutOutput = new CheckOutOutput();

        if ( workHour != null ) {
            checkOutOutput.setStart( workHour.getStart() );
            checkOutOutput.setEnd( workHour.getEnd() );
            checkOutOutput.setStatus( workHour.getStatus() );
            checkOutOutput.setNote( workHour.getNote() );
        }
        if ( user != null ) {
            checkOutOutput.setEmployeeCode( user.getEmployeeCode() );
        }

        return checkOutOutput;
    }
}
