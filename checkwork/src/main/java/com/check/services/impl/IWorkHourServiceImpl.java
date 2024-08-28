package com.check.services.impl;

import com.check.DTO.CheckInOutput;
import com.check.DTO.CheckOutOutput;
import com.check.mapper.WorkHourMapper;
import com.check.models.ENUM.Status;
import com.check.models.User;
import com.check.models.WorkHour;
import com.check.repositories.JPARepository.WorkHourRepository;
import com.check.services.IWorkHourService;
import com.common.utils.GenerateWorkHourCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.check.repositories.JPARepository.WorkHourRepository.Specs.*;

@Slf4j
@Service
public class IWorkHourServiceImpl implements IWorkHourService {
    @Autowired
    private WorkHourMapper workHourMapper;
//    @Autowired
//    private CustomWorkHourRepository customWorkHourRepository;
    @Autowired
    private WorkHourRepository workHourRepository;
    @Override
    public Optional<List<WorkHour>> getAllWorkHourByUsername(User user) {
//        return customWorkHourRepository.getListWorkHourByUserId(user.getId());
        return Optional.of(workHourRepository.findAll(byUserId(user.getId())));
    }

    @Override
    public Optional<CheckInOutput> checkin(User user) {
//        Optional<WorkHour> workHour = customWorkHourRepository.getLastWorkHour(user.getId());
        Optional<WorkHour> workHour = workHourRepository.findOne(byUserId(user.getId()));
        LocalDateTime start = LocalDateTime.now();
        if(workHour.isEmpty()){
            log.info("WORK HOUR SERVICE - CHECK IN - NULL WORK HOUR");
//            return Optional.empty();
        } else if(workHour.get().getStart().toLocalDate().isEqual(LocalDateTime.now().toLocalDate())) {
            log.info("WORK HOUR SERVICE - CHECK IN - CANT CHECK IN IN SAME DAY");
            return Optional.empty();
        }
        Optional<WorkHour> workHourOut = updateCheckIn(start, user);
        if (workHourOut.isEmpty()){
            log.info("WORK HOUR SERVICE - CHECK IN - WORK HOUR UPDATE NULL");
            return Optional.empty();
        }
        CheckInOutput checkInOutput = workHourMapper.workHourToCheckInOutPut(workHour.get(), user);

        return Optional.of(checkInOutput);
    }
    @Override
    public Optional<CheckOutOutput> checkout(LocalDateTime localDateTime, User user) {
//        Optional<WorkHour> workHour = customWorkHourRepository.getLastWorkHour(user.getId());
        List<WorkHour> workHours = workHourRepository.findAll(byUserId(user.getId()));
        if(workHours.isEmpty()){
            log.info("WORK HOUR SERVICE - CHECK OUT - NULL WORK HOUR");
            return Optional.empty();
        } else {
            WorkHour workHour = workHours.get(workHours.size() - 1);
            if (!workHour.getStart().toLocalDate().isEqual(LocalDateTime.now().toLocalDate())) {
                log.info("WORK HOUR SERVICE - CHECK OUT - WRONG DATE");
                return Optional.empty();
            } else if (Duration.between(workHour.getStart(), LocalDateTime.now()).toHours() < 8) {
                log.info("WORK HOUR SERVICE - CHECK OUT - NOT ENOUGH HOUR");
                return Optional.empty();
            } else {
                log.info("WORK HOUR SERVICE - CHECK OUT - GOT CHECKED IN");
                int id = workHour.getId();
                workHour.setId(id);
                workHour.setStatus(Status.DONE);
                workHour.setNote("done");
                workHour.setEnd(LocalDateTime.now());
                workHourRepository.save(workHour);
//                customWorkHourRepository.updateWorkHourCheckout(workHour.get());
//                Optional<WorkHour> workHourOut = customWorkHourRepository.getWorkHourById(id);
                CheckOutOutput checkOutOutput = workHourMapper.workHourToCheckOutOutput(workHour, user);
                return Optional.of(checkOutOutput);
            }
        }
    }

    @Override
    public Optional<WorkHour> testGetLastWorkHour(User user) {
        List<WorkHour> workHours = workHourRepository.findAll(byUserId(user.getId()));
        WorkHour workHour = workHours.get(workHours.size() - 1);
        if (workHour == null){
            log.info("WORK HOUR DAO - GET LAST WORK HOUR - NULL CHECKED IN");
            return Optional.empty();
        } else return Optional.of(workHour);
    }

    @Override
    public String deleteWorkHourById(int id) {
        Optional<WorkHour> workHour = workHourRepository.findOne(byId(id));
        if(workHour.isEmpty()) {
            return "CANT FIND WORK HOUR";
        } else {
            workHourRepository.delete(workHour.get());
            return "SUCCESS";
        }
    }

    private Optional<WorkHour> updateCheckIn(LocalDateTime start, User user){
        LocalDateTime end = LocalDateTime.now();
        String status = String.valueOf(Status.NOTDONE);
        String note = GenerateWorkHourCode.generateWorkHourCode(start, user.getId());
        WorkHour workHour = new WorkHour();
        workHour.setUserid(user.getId());
        workHour.setStart(start);
        workHour.setEnd(end);
        workHour.setStatus(Status.valueOf(status));
        workHour.setNote(note);
        workHourRepository.save(workHour);
//        customWorkHourRepository.saveCheckIn(workHour);
//        return customWorkHourRepository.getCheckInByNote(start, user.getId());
        return workHourRepository.findOne(byNote(note));
    }
}
