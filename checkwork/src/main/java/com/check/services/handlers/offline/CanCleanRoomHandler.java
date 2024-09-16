package com.check.services.handlers.offline;

import com.check.models.Room;
import com.check.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CanCleanRoomHandler implements RoomPrepareHandler{
    private final IRoomService roomService;

    public CanCleanRoomHandler(IRoomService roomService) {
        this.roomService = roomService;
        roomService.cleanRoom();
    }

    @Override
    public String handleRequest(List<String> data, RoomPrepareChain roomChain, Room room) {
        roomService.cleanRoom();
        return "";
    }
    public CanCleanRoomHandler cleanRoom(){
        roomService.cleanRoom();
        return this;
    }
}
