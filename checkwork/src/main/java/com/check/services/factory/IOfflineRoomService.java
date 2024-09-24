package com.check.services.factory;

import com.check.DTO.handlers.RequestHandlerDTO;
import com.check.DTO.handlers.ResponseHandlerDTO;
//import com.check.repositories.JPARepository.AppointmentRepository;
import com.check.services.IAppointmentService;
import com.check.services.IRoomService;
import com.check.services.handlers.offline.*;
import com.common.utils.ConvertStrTime;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Slf4j
@Service
public class IOfflineRoomService{
    @Autowired
    private IRoomService roomService;
    @Autowired
    private IAppointmentService appointmentService;
    public String prepareMeetingHandlers(List<String> data){
        RequestHandlerDTO request = RequestHandlerDTO.builder()
                .capacity(Integer.parseInt(data.get(1)))
                .start(ConvertStrTime.convertStringToLocalDateTime(data.get(2)))
                .end(ConvertStrTime.convertStringToLocalDateTime(data.get(3)))
                .build();
        ResponseHandlerDTO response = ResponseHandlerDTO.builder().build();
        RoomPrepareChain chain = new RoomPrepareChain()
                .setHandle(new CanCleanRoomHandler(roomService))
                .setHandle(new CheckRoomAvailabilityHandler(roomService, appointmentService))
                .setHandle(new UpdateRoomStatusHandler(roomService));
        chain.handle(request, response);
        return response.getResString();
    }
}
