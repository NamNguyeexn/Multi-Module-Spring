package com.check.repositories;

import com.check.models.WorkHour;
import com.check.repositories.JPARepository.WorkHourRepository;
import com.common.utils.GenerateWorkHourCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
//@EnableJpaRepositories(basePackages = {"com.check.repositories.JPARepository.WorkHourRepository"})
public class CustomWorkHourRepository {
    @Autowired
    private WorkHourRepository workHourRepository;
    public Optional<WorkHour> getWorkHourById(int id){
        return workHourRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("id"), id)
        );
    }
    public Optional<List<WorkHour>> getListWorkHourByUserId(int userid){
        return Optional.of(workHourRepository.findAll(
            (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("userid"), userid)
        ));
    }
    public Optional<WorkHour> getCheckInByNote(LocalDateTime start, int userid){
        return workHourRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("note"),
                        GenerateWorkHourCode.generateWorkHourCode(start, userid))
        );
    }
    public Optional<WorkHour> getLastWorkHour(int userId) {
        Optional<List<WorkHour>> workHours = getListWorkHourByUserId(userId);
        if (workHours.get().isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(workHours.get().get(workHours.get().size() - 1));
        }
    }
    @Transactional
    public void saveCheckIn(WorkHour workHour) {
        workHourRepository.save(workHour);
    }
    public void deleteWorkHourById(int id) {
        workHourRepository.delete(
                (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id)
        );
    }
    public void updateWorkHourCheckout(WorkHour workHour) {
        workHourRepository.save(workHour);
    }
}
