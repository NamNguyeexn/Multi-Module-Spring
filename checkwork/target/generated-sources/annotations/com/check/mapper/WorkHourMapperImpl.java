package com.check.mapper;

import com.check.DTO.CheckInOutput;
import com.check.DTO.CheckOutOutput;
import com.check.models.ENUM.Status;
import com.check.models.User;
import com.check.models.WorkHour;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-29T14:38:33+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class WorkHourMapperImpl implements WorkHourMapper {

    @Override
    public CheckInOutput toCheckInOutPut(String start, String employeeCode, Status status) {
        if ( start == null && employeeCode == null && status == null ) {
            return null;
        }

        CheckInOutput checkInOutput = new CheckInOutput();

        if ( start != null ) {
            checkInOutput.setStart( start );
        }
        if ( employeeCode != null ) {
            checkInOutput.setEmployeeCode( employeeCode );
        }
        if ( status != null ) {
            checkInOutput.setStatus( status );
        }

        return checkInOutput;
    }

    @Override
    public CheckOutOutput toCheckOutOutput(WorkHour workHour, User user, String start, String end) {
        if ( workHour == null && user == null && start == null && end == null ) {
            return null;
        }

        CheckOutOutput checkOutOutput = new CheckOutOutput();

        if ( workHour != null ) {
            checkOutOutput.setStatus( workHour.getStatus() );
            checkOutOutput.setNote( workHour.getNote() );
        }
        if ( user != null ) {
            checkOutOutput.setEmployeeCode( user.getEmployeeCode() );
        }
        if ( start != null ) {
            checkOutOutput.setStart( start );
        }
        if ( end != null ) {
            checkOutOutput.setEnd( end );
        }

        return checkOutOutput;
    }
}
