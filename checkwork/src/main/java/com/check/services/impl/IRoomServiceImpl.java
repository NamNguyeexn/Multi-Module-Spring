package com.check.services.impl;

import com.check.models.Appointment;
import com.check.models.Room;
import com.check.repositories.CustomRoomRepository;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class IRoomServiceImpl implements IRoomService {
    @Autowired
    private CustomRoomRepository roomRepository;
    @Autowired
    private IAppointmentService appointmentService;
    @Override
    public Optional<Room> getRoomByName(String name) {
        return roomRepository.getRoomByName(name);
    }

    @Override
    public Optional<List<Room>> getRooms() {
        return roomRepository.getRooms();
    }

    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void cleanRoom() {
        Optional<List<Appointment>> appointments = appointmentService.getAppointments();
        if (appointments.isPresent()){
            for(Appointment a : appointments.get()){
                if (a.getEnd().isBefore(LocalDateTime.now())){
                    Optional<Room> room = getRoomByName(a.getRoom());
                    if(room.isPresent()){
                        room.get().setOpen(true);
                        saveRoom(room.get());
                    }
                }
            }
        }
    }
}
