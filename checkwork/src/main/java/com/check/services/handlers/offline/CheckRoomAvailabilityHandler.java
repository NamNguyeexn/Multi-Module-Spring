package com.check.services.handlers.offline;

import com.check.models.Room;
import com.check.services.IRoomService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckRoomAvailabilityHandler implements RoomPrepareHandler{
    private final IRoomService roomService;

    public CheckRoomAvailabilityHandler(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public String handleRequest(List<String> data, RoomPrepareChain roomChain, Room room) {
        return "";
    }
    public List<Room> getOpenRooms(List<String> data) {
        Optional<List<Room>> rooms = roomService.getRooms();
        List<Room> res = new ArrayList<>();
        if(rooms.isEmpty()) return null;
        for(Room r : rooms.get()){
            if(r.isOpen()){
                res.add(r);
            }
        }
        return res;
    }
}
