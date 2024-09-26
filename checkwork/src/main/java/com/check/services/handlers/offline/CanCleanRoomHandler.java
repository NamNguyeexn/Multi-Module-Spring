package com.check.services.handlers.offline;

import com.check.dto.handlers.RequestHandlerDTO;
import com.check.dto.handlers.ResponseHandlerDTO;
import com.check.services.IRoomService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CanCleanRoomHandler implements RoomPrepareHandler{
    private final IRoomService roomService;

    public CanCleanRoomHandler(IRoomService roomService) {
        this.roomService = roomService;
        roomService.cleanRoom();
    }

    @Override
    public RoomPrepareChain handleRequest(RequestHandlerDTO request, ResponseHandlerDTO response) {
        roomService.cleanRoom();
        log.info("CLEANED ROOM");
        return new RoomPrepareChain(this);
    }
}
