package com.check.services.handlers.offline;

import com.check.models.Room;

import java.util.List;

public interface RoomPrepareHandler {
    String handleRequest(List<String> data, RoomPrepareChain roomChain, Room room);
}
