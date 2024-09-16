package com.check.chain_of_responsibility.services;

import com.check.chain_of_responsibility.models.ENUM.Category;
import com.check.chain_of_responsibility.models.Payslip;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PayslipService {
    Optional<Payslip> getPayslipById(int id);
    Optional<List<Payslip>> getPayslipsByUsername(String username);
    Optional<List<Payslip>> getPayslipsAfterTime(LocalDate localDate);
    Optional<List<Payslip>> getPayslipsByCategory(Category category);
}
