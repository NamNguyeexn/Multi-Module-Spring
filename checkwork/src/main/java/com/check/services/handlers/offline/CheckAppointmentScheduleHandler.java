package com.check.services.handlers.offline;

import com.check.models.Appointment;
import com.check.models.Room;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;

import java.time.LocalDateTime;
import java.util.List;

public class CheckAppointmentScheduleHandler implements RoomPrepareHandler{
    private final IAppointmentService appointmentService;

    public CheckAppointmentScheduleHandler(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public String handleRequest(List<String> data, RoomPrepareChain roomChain, Room room) {
        String res = "";
        LocalDateTime startR = LocalDateTime.parse(data.get(2));
        LocalDateTime endR = LocalDateTime.parse(data.get(2));
        if(room.getCapacity() >= Integer.parseInt(data.get(1))) {
            res += room.getName();
            List<Appointment> appointments = appointmentService.getAppointmentsByRoomName(room.getName());
            if(!appointments.isEmpty()){
                for(Appointment a : appointments){
                    if((startR.isBefore(a.getStart()) && endR.isBefore(a.getStart())) ||
                    (startR.isAfter(a.getEnd()) && endR.isAfter(a.getEnd()))){
                        data.add(room.getName());
                        return res;
                    }
                }
            }
        }
        return null;
    }
//    public String prepareAppoint(List<String> data, Room room){
//
//    }
}
