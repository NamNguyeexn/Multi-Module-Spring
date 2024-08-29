//package com.check.listeners;
//
//import com.check.models.Schedule;
//import com.check.repositories.JPARepository.ScheduleRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.BatchStatus;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Slf4j
//public class JobCompletionNotificationListener implements JobExecutionListener {
//    private final ScheduleRepository scheduleRepository;
//
//    public JobCompletionNotificationListener(ScheduleRepository scheduleRepository) {
//        this.scheduleRepository = scheduleRepository;
//    }
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
//            log.info("!!! JOB FINISHED! Time to verify the results");
//            scheduleRepository.findAll().forEach(
//                    schedule -> {
//                        log.info("Found <{{}}> in the database", schedule);
//                    }
//            );
//        }
//    }
//
//}
