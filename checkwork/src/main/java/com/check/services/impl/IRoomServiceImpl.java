package com.check.services.impl;

import com.check.models.Room;
import com.check.repositories.CustomRoomRepository;
import com.check.repositories.JPARepository.RoomRepository;
import com.check.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IRoomServiceImpl implements IRoomService {
    @Autowired
    private CustomRoomRepository roomRepository;
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
}
