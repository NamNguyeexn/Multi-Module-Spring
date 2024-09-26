package com.check.services.handlers.offline;

import com.check.dto.handlers.RequestHandlerDTO;
import com.check.dto.handlers.ResponseHandlerDTO;

public interface RoomPrepareHandler {
    RoomPrepareChain handleRequest(RequestHandlerDTO request, ResponseHandlerDTO response);
}
