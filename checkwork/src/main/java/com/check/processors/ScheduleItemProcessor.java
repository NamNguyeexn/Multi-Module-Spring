//package com.check.processors;
//
//import com.check.adapters.ScheduleAdapter;
//import com.check.models.Appointment;
//import com.check.models.Schedule;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ScheduleItemProcessor implements ItemProcessor<Appointment, Schedule> {
//    @Autowired
//    private ScheduleAdapter scheduleAdapter;
//    @Override
//    public Schedule process(final Appointment item) throws Exception {
//        final String hostname = scheduleAdapter.toHostname(item.getHostid());
//        final String joinname = scheduleAdapter.toJoinsname(item.getJoinid());
//        return new Schedule(hostname, joinname, item.getStart(), item.getEnd(), item.getType(), item.getDetail());
//    }
//}
