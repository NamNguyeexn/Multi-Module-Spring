package com.check.services.handlers.offline;

import com.check.DTO.handlers.RequestHandlerDTO;
import com.check.DTO.handlers.ResponseHandlerDTO;
import com.check.models.Room;

import java.util.List;

public interface RoomPrepareHandler {
    RoomPrepareChain handleRequest(RequestHandlerDTO request, ResponseHandlerDTO response);
}
