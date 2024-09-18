package com.check.services.handlers.offline;

import com.check.DTO.handlers.RequestHandlerDTO;
import com.check.DTO.handlers.ResponseHandlerDTO;
import com.check.models.Room;
import com.check.services.IRoomService;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.LinkOption;
import java.util.Optional;
@Slf4j
public class UpdateRoomStatusHandler implements RoomPrepareHandler{
    private final IRoomService roomService;

    public UpdateRoomStatusHandler(IRoomService roomService) {
        this.roomService = roomService;
    }
    @Override
    public RoomPrepareChain handleRequest(RequestHandlerDTO request, ResponseHandlerDTO response) {
        Optional<Room> r = roomService.getRoomByName(response.getName());
        r.ifPresent(
            room -> {
                r.get().setOpen(false);
                String res = r.get().getName();
                res += "@" + r.get().getCapacity();
                response.setResString(res);
                roomService.saveRoom(r.get());
            }
        );
        log.info("UPDATED ROOM");
        return new RoomPrepareChain(this);
    }
}
