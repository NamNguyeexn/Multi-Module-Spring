package com.check.services;

import com.check.dto.CheckInOutput;
import com.check.dto.CheckOutOutput;
import com.check.models.User;
import com.check.models.WorkHour;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public interface IWorkHourService {
    Optional<List<WorkHour>> getAllWorkHourByUsername(User user);
    Optional<CheckInOutput> checkin(User user);
    Optional<CheckOutOutput> checkout(LocalDateTime end, User user);
    Optional<WorkHour> testGetLastWorkHour(User user);
    String deleteWorkHourById(int id);
    int getDayWorkedByUser(User user);
    Optional<WorkHour> getWorkHourById(int id);
    Optional<List<WorkHour>> getWHsByUserId(int userid);
    boolean checkIfWorkHourExist(int id);
}
