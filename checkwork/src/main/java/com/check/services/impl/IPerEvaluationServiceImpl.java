package com.check.services.impl;

import com.check.models.PerEvaluation;
import com.check.models.UserState;
import com.check.models.WorkHour;
import com.check.repositories.JPARepository.PerEvaluationRepository;
import com.check.services.IPerEvaluationService;
import com.check.services.IWorkHourService;
import com.check.services.state.IUserStateService;
import com.check.services.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.check.repositories.JPARepository.PerEvaluationRepository.Specs.*;

@Service
@Primary
public class IPerEvaluationServiceImpl implements IPerEvaluationService {
    @Autowired
    private SalaryStrategy salaryStrategy;
    @Autowired
    private PerEvaluationRepository evaRepository;
    @Autowired
    private IUserStateService userStateService;
    @Autowired
    private IWorkHourService workHourService;
    @Override
    public Optional<PerEvaluation> getPerEvaluationById(int id) {
        return evaRepository.findById(id);
    }

    @Override
    public List<PerEvaluation> getPEsByUserStateId(int userStateId) {
        List<PerEvaluation> evaList = evaRepository.findAll(byUserStateId(userStateId));
        List<PerEvaluation> res = new ArrayList<>();
        evaList.stream()
                .filter(e -> {
                    Optional<WorkHour> workHour = workHourService.getWorkHourById(e.getWorkhourid());
                    return workHour.isPresent() &&
                            workHour.get().getStart().getMonth() == LocalDateTime.now().getMonth();
                })
                .forEach(res::add);
        return res;
    }

    @Override
    public Long getSalary(List<PerEvaluation> perEvaluation) {
//        if(LocalDateTime.now().getDayOfMonth() != 10) return 0L;
//        else {
            UserState userState = userStateService.getUserStateById(perEvaluation.get(0).getUserstateid());
            boolean isRecruitment = false;
            long res = 0;
            switch (userState.getState()){
                case RECRUITMENT -> isRecruitment = true;
                case TRAINING -> {
                    salaryStrategy.setSalaryStrategy(new TrainingSalary());
                    res = salaryStrategy.executeSalary(perEvaluation);
                }
                case EVALUATION -> {
                    salaryStrategy.setSalaryStrategy(new EvaluationSalary());
                    res = salaryStrategy.executeSalary(perEvaluation);
                }
                case PROMOTION -> {
                    salaryStrategy.setSalaryStrategy(new PromotionSalary());
                    res = salaryStrategy.executeSalary(perEvaluation);
                }
                default -> throw new IllegalStateException("Unexpected value: " + userState.getState());
            }
            if(isRecruitment) res = 200000;
            return res;
//        }
    }
}
