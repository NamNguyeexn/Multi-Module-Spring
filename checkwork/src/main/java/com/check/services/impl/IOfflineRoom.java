package com.check.services.impl;

import com.check.DTO.Meeting;
import com.check.models.Appointment;
import com.check.models.Room;
import com.check.repositories.JPARepository.AppointmentRepository;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Slf4j
@Service
//@Qualifier("offline")
public class IOfflineRoom implements Meeting {
//    @Qualifier("IRoomService")
//    @Autowired
    private final IRoomService roomService;
//    @Autowired
    private final IAppointmentService appointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;
    private String name;
    private Room room;

    public IOfflineRoom(IAppointmentService appointmentService, IRoomService roomService) {
        this.appointmentService = appointmentService;
        this.roomService = roomService;
    }
//    public IOfflineRoom() {}

    @Override
    public String getMeetingType() {
        return "OFFLINE";
    }
    @Override
    public String prepareRoom(List<String> data) {
        // don phong
        Optional<List<Appointment>> appointmentList = appointmentService.getAppointments();
        if (appointmentList.isEmpty()) {
            log.info("No appointments found");
        } else {
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
//    private Optional<List<Appointment>> getAppointments(){
//        return Optional.of(appointmentRepository.findAll());
//    }
}
