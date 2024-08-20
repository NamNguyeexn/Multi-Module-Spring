package com.check.services;

import com.check.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IRoomService {
    Optional<Room> getRoomByName(String name);
    Optional<List<Room>> getRooms();
    void saveRoom(Room room);
}
