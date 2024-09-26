package com.check.controllers;

import com.check.dto.*;
import com.check.jwt.JwtTokenService;
import com.check.abstract_factories.IRewardAbstractFactory;
import com.check.abstract_factories.models.*;
import com.check.models.User;
import com.check.models.WorkHour;
import com.check.services.IHumanService;
import com.check.services.ITestService;
import com.check.services.IUserService;
import com.check.services.IWorkHourService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;


@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IWorkHourService IWorkHourService;
    @Autowired
    private IRewardAbstractFactory IRewardAbstractFactory;
    @Autowired
    private IUserService IUserService;
    @Autowired
    private IHumanService humanService;
    @Autowired
    @Qualifier("Service1")
    private ITestService testService1;
    @Autowired
    @Qualifier("Service2")
    private ITestService testService2;
    @GetMapping()
    public ResponseEntity<?> localhost(HttpServletRequest request){
        String username = jwtTokenService.getUsername(request);
        UserInput userInput = new UserInput(username, "passs");
        UserOutput userOutput = new UserOutput(userInput.getUsername());
        return ResponseEntity.ok().body(userOutput);
    }
    @GetMapping("/getLastWorkHour")
    public ResponseEntity<WorkHour> testGetLastWorkHour(HttpServletRequest request) {
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = IUserService.getUserByUsername(username);
        if(user.isEmpty()) {
            log.info("NULL USER");
            return ResponseEntity.badRequest().body(null);
        } else {
            Optional<WorkHour> workHour = IWorkHourService.testGetLastWorkHour(user.get());
            if(workHour.isEmpty()){
                log.info("NULL USER");
                return ResponseEntity.badRequest().body(null);
            } else {
                return ResponseEntity.ok().body(workHour.get());
            }
        }
    }
    @GetMapping("/show1")
    public ResponseEntity<String> getShow(){
        return ResponseEntity.ok().body(
                testService1.getHello() +
                        "\n" +
                        testService1.getData() +
                        "\n" +
                        testService2.getHello() +
                        "\n" +
                        testService2.getData()
        );
    }
    @GetMapping("/init1")
    public ResponseEntity<String> getInit1(){
        testService1.addData();
        testService2.addData();
        return ResponseEntity.ok().body("ADDED DATA TO TEST SERVICE 1, 2");
    }
    @GetMapping("/minus")
    public ResponseEntity<String> getMinus(HttpServletRequest request){
        String alert = "";
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = IUserService.getUserByUsername(username);
        if(LocalTime.now().isAfter(LocalTime.of(8, 0))){
            MinusLate iMinus = IRewardAbstractFactory.newChange(MinusLate.class, user.get().getUsername(), 5000);
            alert = "Dear "
                    + humanService.getHumanById(user.get().getHumanid()).get().getName()
                    + " "
                    + iMinus.getReason()
                    +  " -"
                    + iMinus.getValue(iMinus.getMinus());
            return ResponseEntity.ok().body(alert);
        } else {
            MinusPunish iMinus = IRewardAbstractFactory.newChange(MinusPunish.class, user.get().getUsername(), 5000);
            alert = "Dear "
                    + humanService.getHumanById(user.get().getHumanid()).get().getName()
                    + ", "
                    + iMinus.getReason()
                    + " -"
                    + iMinus.getValue(iMinus.getMinus());
            return ResponseEntity.ok().body(alert);
        }
    }
    @GetMapping("/bonus")
    public ResponseEntity<String> getBonus(HttpServletRequest request){
        String alert = "";
        String username = jwtTokenService.getUsername(request);
        Optional<User> user = IUserService.getUserByUsername(username);
        if(LocalDate.now().isEqual(humanService.getHumanById(user.get().getHumanid()).get().getDob().toLocalDate())){
            BonusBirthday iBonus = IRewardAbstractFactory.newChange(BonusBirthday.class, user.get().getUsername(), 5000);
            alert = "Dear "
                    + humanService.getHumanById(user.get().getHumanid()).get().getName()
                    + " "
                    + iBonus.getReason()
                    +  " +"
                    + iBonus.getBonus(iBonus.getBonus());
            return ResponseEntity.ok().body(alert);
        } else {
            BonusReward iBonus = IRewardAbstractFactory.newChange(BonusReward.class, user.get().getUsername(), 5000);
            alert = "Dear "
                    + humanService.getHumanById(user.get().getHumanid()).get().getName()
                    + ", "
                    + iBonus.getReason()
                    + " +"
                    + iBonus.getBonus(iBonus.getBonus());
            return ResponseEntity.ok().body(alert);
        }
    }
}
