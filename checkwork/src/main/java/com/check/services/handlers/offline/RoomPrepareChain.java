package com.check.services.handlers.offline;

import com.check.dto.handlers.RequestHandlerDTO;
import com.check.dto.handlers.ResponseHandlerDTO;

import java.util.ArrayList;
import java.util.List;

public class RoomPrepareChain {
    private RoomPrepareHandler roomPrepareHandler;
    private final List<RoomPrepareHandler> list = new ArrayList<>();

    public RoomPrepareChain() {
    }

    public RoomPrepareChain(RoomPrepareHandler roomPrepareHandler) {
        this.roomPrepareHandler = roomPrepareHandler;
    }
    public void handle(RequestHandlerDTO request, ResponseHandlerDTO response){
        list.forEach(h -> h.handleRequest(request, response));
    }
    public RoomPrepareChain setHandle(RoomPrepareHandler roomPrepareHandler){
        this.roomPrepareHandler = roomPrepareHandler;
        list.add(roomPrepareHandler);
        return this;
    }
}
