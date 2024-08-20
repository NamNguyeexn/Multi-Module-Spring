package com.check.DTO;

import com.check.models.Appointment;
import com.check.models.Room;
import com.check.repositories.JPARepository.RoomRepository;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Slf4j
@Component
public class OfflineRoom implements Meeting {
    @Qualifier("IRoomService")
    @Autowired
    private IRoomService roomService;
    @Qualifier("IAppointmentService")
    @Autowired
    private IAppointmentService appointmentService;
    private String name;
    private Room room;

    @Override
    public String getMeetingType() {
        return "OFFLINE";
    }

    @Override
    public String prepareRoom(List<String> data) {
        // don phong
        Optional<List<Appointment>> appointmentList = appointmentService.getAppointments();
        if (appointmentList.isPresent()) {
            for(Appointment appointment : appointmentList.get()) {
                if (appointment.getEnd().isBefore(LocalDateTime.now())) {
                    Optional<Room> room1 = roomService.getRoomByName(name);
                    room1.get().setStatus(true);
                    roomService.saveRoom(room1.get());
                }
            }
        }
        // chuan bi phong hop
        List<Room> rooms = roomService.getRooms().get();
        LocalDateTime startR = LocalDateTime.parse(data.get(2));
        LocalDateTime endR = LocalDateTime.parse(data.get(3));
        for(Room r : rooms){
            if (r.isStatus()){
                if(r.getCapacity() >= Integer.parseInt(data.get(1))){
                    setRoom(r);
                    Optional<List<Appointment>> appointments = appointmentService.getAppointmentsByRoomName(r.getName());
                    if(appointments.isPresent()){
                        for(Appointment a : appointments.get()){
                            if(
                                    (startR.isBefore(a.getStart()) && endR.isBefore(a.getStart())) ||
                                            (startR.isAfter(a.getEnd()) && endR.isAfter(a.getEnd()))){
                                r.setStatus(false);
                                roomService.saveRoom(r);
                            }
                        }
                    }
                    break;
                }
            }
        }
        return String.valueOf(room.getCapacity());
    }

    @Override
    public String toString(String[] data) {
        return data[1] + ";" + data[2];
    }
    @Override
    public String getRoomName() {
        return room.getName();
    }
}
