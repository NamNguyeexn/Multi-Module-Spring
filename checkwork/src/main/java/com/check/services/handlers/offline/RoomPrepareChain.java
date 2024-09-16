package com.check.services.handlers.offline;

import com.check.models.Room;

import java.util.List;

public class RoomPrepareChain {
    private RoomPrepareHandler roomPrepareHandler;
    private Room room;

    public RoomPrepareChain() {
    }

    public RoomPrepareChain(RoomPrepareHandler roomPrepareHandler, Room room) {
        this.roomPrepareHandler = roomPrepareHandler;
        this.room = room;
    }
    public String handle(List<String> data){
        if(roomPrepareHandler != null){
            return roomPrepareHandler.handleRequest(data, this, room);
        }
        return null;
    }
    public RoomPrepareChain setHandle(RoomPrepareHandler roomPrepareHandler){
        this.roomPrepareHandler = roomPrepareHandler;
        return this;
    }
}
