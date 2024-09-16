package com.check.services.handlers.offline;

import com.check.models.Room;
import com.check.services.IRoomService;

import java.util.List;
import java.util.Optional;

public class UpdateRoomStatusHandler implements RoomPrepareHandler{
    private final IRoomService roomService;

    public UpdateRoomStatusHandler(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public String handleRequest(List<String> data, RoomPrepareChain roomChain, Room room) {
        Optional<Room> r = roomService.getRoomByName(data.get(data.size() - 1));
        r.get().setOpen(false);
        String res = "";
        res += "@" + r.get().getCapacity();
        roomService.saveRoom(r.get());
        return res;
    }
}
