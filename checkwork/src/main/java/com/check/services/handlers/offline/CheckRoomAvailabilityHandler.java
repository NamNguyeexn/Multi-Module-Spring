package com.check.services.handlers.offline;

import com.check.dto.handlers.RequestHandlerDTO;
import com.check.dto.handlers.ResponseHandlerDTO;
import com.check.models.Appointment;
import com.check.models.Room;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
@Slf4j
public class CheckRoomAvailabilityHandler implements RoomPrepareHandler{
    private final IRoomService roomService;
    private final IAppointmentService appointmentService;
    public CheckRoomAvailabilityHandler(IRoomService roomService, IAppointmentService appointmentService) {
        this.roomService = roomService;
        this.appointmentService = appointmentService;
    }

    @Override
    public RoomPrepareChain handleRequest(RequestHandlerDTO request, ResponseHandlerDTO response) {
        Optional<List<Room>> rooms = roomService.getRooms();
        if(rooms.isPresent()){
            Optional<Room> room = rooms.get().stream()
                    .filter(Room::isOpen)
                    .filter(r -> r.getCapacity() >= request.getCapacity())
                    .filter(r -> appointmentService.getAppointmentsByRoomName(r.getName()).stream()
                            .noneMatch(a -> overlaps(a, request)))
                    .findFirst();
            if (room.isPresent()){
                response.setCapacity(room.get().getCapacity());
                response.setName(room.get().getName());
                response.setOpen(true);
            }
        }
        log.info("CHECK ROOM AVAILABLE");
        return new RoomPrepareChain(this);
    }
    private boolean overlaps(Appointment a, RequestHandlerDTO request){
        return request.getStart().isBefore(a.getEnd()) && request.getEnd().isAfter(a.getStart());
    }
}
