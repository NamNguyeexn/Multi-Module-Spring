package com.check.bridge.controllers;

import com.check.jwt.JwtTokenService;
import com.check.bridge.DTO.DetailEmployee;
import com.check.bridge.factory.IEmployeeFactory;
import com.check.bridge.factory.EmployeeFactoryProducer;
import com.check.bridge.models.Employee;
import com.check.bridge.services.impl.HourSalary;
import com.check.bridge.services.impl.MonthSalary;
import com.check.models.ENUM.Role;
import com.check.models.User;
import com.check.services.IHumanService;
import com.check.services.IUserService;
import com.check.services.IWorkHourService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IWorkHourService workHourService;
    @Autowired
    private IHumanService humanService;
    @Autowired
    private EmployeeFactoryProducer employeeFactoryProducer;
    @GetMapping("/month")
    public ResponseEntity<DetailEmployee> getMonthSalary(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Employee employee;
        if (user.isEmpty()) return ResponseEntity.badRequest().body(null);
        int day = workHourService.getDayWorkedByUser(user.get());
        User u = user.get();
        if(user.get().getRole().compareTo(Role.ADMIN) == 0) {
            IEmployeeFactory employeeFactory = employeeFactoryProducer.getFactory("ADMIN");
            assert employeeFactory != null;
            employee = employeeFactory.getEmployeeFactory(
                    new MonthSalary(day + 1),
                    u.getUsername(),
                    u.getRole(),
                    u.getEmployeeCode()
            );
        } else {
            IEmployeeFactory employeeFactory = employeeFactoryProducer.getFactory("USER");
            assert employeeFactory != null;
            employee = employeeFactory.getEmployeeFactory(
                    new MonthSalary(day),
                    u.getUsername(),
                    u.getRole(),
                    u.getEmployeeCode()
            );
        }
        DetailEmployee detailEmployee = DetailEmployee.builder()
                .name(humanService.getHumanById(u.getId()).get().getName())
                .role(u.getRole().toString())
                .employeeCode(u.getEmployeeCode())
                .email(u.getEmail())
                .department(u.getDepartment().toString())
                .salary(employee.getMonthlySalary(day))
                .build();
        return ResponseEntity.ok().body(detailEmployee);
    }
    @GetMapping("")
    public ResponseEntity<?> getHourSalary(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = userService.getUserByUsername(username);
        Employee employee;
        if (user.isEmpty()) return ResponseEntity.badRequest().body(null);
        User u = user.get();
        if(user.get().getRole().compareTo(Role.ADMIN) == 0) {
            IEmployeeFactory employeeFactory = employeeFactoryProducer.getFactory("ADMIN");
            assert employeeFactory != null;
            employee = employeeFactory.getEmployeeFactory(
                    new HourSalary(),
                    u.getUsername(),
                    u.getRole(),
                    u.getEmployeeCode()
            );
        } else {
            IEmployeeFactory employeeFactory = employeeFactoryProducer.getFactory("USER");
            assert employeeFactory != null;
            employee = employeeFactory.getEmployeeFactory(
                    new HourSalary(),
                    u.getUsername(),
                    u.getRole(),
                    u.getEmployeeCode()
            );
        }
        DetailEmployee detailEmployee = DetailEmployee.builder()
                .name(humanService.getHumanById(u.getId()).get().getName())
                .role(u.getRole().toString())
                .employeeCode(u.getEmployeeCode())
                .email(u.getEmail())
                .department(u.getDepartment().toString())
                .salary(employee.getHourlySalary())
                .build();
        return ResponseEntity.ok().body(detailEmployee);
    }
}
