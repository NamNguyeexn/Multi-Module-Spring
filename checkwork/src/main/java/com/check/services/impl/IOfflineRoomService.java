package com.check.services.impl;

import com.check.models.Appointment;
import com.check.models.Room;
import com.check.repositories.JPARepository.AppointmentRepository;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Slf4j
@Service
public class IOfflineRoomService{
    @Autowired
    private IRoomService roomService;
    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;
    public String prepareMeeting(List<String> data) {
        String res = "";
        // don phong
        roomService.cleanRoom();
        // chuan bi phong hop
        Optional<List<Room>> rooms = roomService.getRooms();
        if(rooms.isPresent()){
            LocalDateTime startR = LocalDateTime.parse(data.get(2));
            LocalDateTime endR = LocalDateTime.parse(data.get(3));
            for(Room r : rooms.get()){
                if (r.isOpen()){
                    if(r.getCapacity() >= Integer.parseInt(data.get(1))){
                        res += r.getName();
                        List<Appointment> appointments = appointmentService.getAppointmentsByRoomName(r.getName());
                        if(!appointments.isEmpty()){
                            for(Appointment a : appointments){
                                if(
                                        (startR.isBefore(a.getStart()) && endR.isBefore(a.getStart())) ||
                                                (startR.isAfter(a.getEnd()) && endR.isAfter(a.getEnd()))){
                                    r.setOpen(false);
                                    res += "@" + r.getCapacity();
                                    roomService.saveRoom(r);
                                    break;
                                }
                            }
                        } else {
                            r.setOpen(false);
                            res += "@" + r.getCapacity();
                            roomService.saveRoom(r);
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }
}
