package com.check.services;

import com.check.models.PerEvaluation;

import java.util.List;
import java.util.Optional;

public interface IPerEvaluationService {
    Optional<PerEvaluation> getPerEvaluationById(int id);
    List<PerEvaluation> getPEsByUserStateId(int userStateId);
    Long getSalary(List<PerEvaluation> perEvaluation);
    boolean checkIfWorkHourExists(int workhourId);
}
