package com.check.services.handlers.offline;

import com.check.DTO.handlers.RequestHandlerDTO;
import com.check.DTO.handlers.ResponseHandlerDTO;
import com.check.models.Room;
import com.check.services.IRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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
