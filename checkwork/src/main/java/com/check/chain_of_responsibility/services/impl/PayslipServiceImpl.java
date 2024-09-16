package com.check.chain_of_responsibility.services.impl;

import com.check.chain_of_responsibility.models.ENUM.Category;
import com.check.chain_of_responsibility.models.Payslip;
import com.check.chain_of_responsibility.repository.PayslipRepository;
import com.check.chain_of_responsibility.services.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.check.chain_of_responsibility.repository.PayslipRepository.Specs.*;

@Service
public class PayslipServiceImpl implements PayslipService {
    @Autowired
    private PayslipRepository payslipRepository;

    @Override
    public Optional<Payslip> getPayslipById(int id) {
        return payslipRepository.findById(id);
    }

    @Override
    public Optional<List<Payslip>> getPayslipsByUsername(String username) {
        return Optional.of(payslipRepository.findAll(byUsername(username)));
    }

    @Override
    public Optional<List<Payslip>> getPayslipsAfterTime(LocalDate localDate) {
        return Optional.of(payslipRepository.findAll(byAfterTime(localDate)));
    }

    @Override
    public Optional<List<Payslip>> getPayslipsByCategory(Category category) {
        return Optional.of(payslipRepository.findAll(byType(category)));
    }
}
