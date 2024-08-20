package com.check.services.impl;

import com.check.models.Appointment;
import com.check.repositories.CustomAppointmentRepository;
import com.check.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class IAppointmentServiceImpl implements IAppointmentService {
    @Autowired
    private CustomAppointmentRepository appointmentRepository;
    @Override
    public Optional<Appointment> getAppointmentByAppointmentId(int id) {
        return appointmentRepository.getAppointmentByAppointmentId(id);
    }

    @Override
    public Optional<List<Appointment>> getAppointmentsByHostId(int hostid) {
        return appointmentRepository.getAppointmentsByHostId(hostid);
    }

    @Override
    public void saveAppointment(Appointment appointment) {
//        StringBuilder joinidStr = new StringBuilder();
//        for (int i = 0; i < joinid.length; i++) {
//            joinidStr.append(i);
//            if (i != joinid.length - 1) {
//                joinidStr.append(",");
//            }
//        }
//        appointment.setJoinid(joinidStr.toString());
        appointmentRepository.save(appointment);
    }

    @Override
    public Optional<List<Integer>> getJoinIdsByAppointmentId(int id) {
        List<Integer> joins = new ArrayList<>();
        Optional<Appointment> appointmentOptional = appointmentRepository.getAppointmentByAppointmentId(id);
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            String[] data = appointment.getJoinid().split(",");
            for (String datum : data) {
                joins.add(Integer.parseInt(datum));
            }
        }
        return Optional.of(joins);
    }

    @Override
    public Optional<List<Appointment>> getAppointmentsByJoinId(int joinid) {
//        List<String> joins = new ArrayList<>();
        List<Appointment> res = new ArrayList<>();
        Optional<List<Appointment>> appointments = appointmentRepository.getAppointments();
        if (appointments.isPresent()) {
//            for(Appointment appointment : appointments.get()) {
//                joins.add(appointment.getJoinid());
//            }
            for (Appointment a : appointments.get()){
                if (a.getJoinid().contains(String.valueOf(joinid))){
                    res.add(a);
                }
            }
        }
        return Optional.of(res);
    }

    @Override
    public Optional<List<Appointment>> getAppointmentsByRoomName(String name) {
        List<Appointment> res = new ArrayList<>();
        Optional<List<Appointment>> appointments = appointmentRepository.getAppointments();
        if (appointments.isPresent()) {
            for(Appointment a : appointmentRepository.getAppointments().get()) {
                if(a.getName().equals(name) && a.getEnd().isBefore(LocalDateTime.now())){
                    res.add(a);
                }
            }
        }
        return Optional.of(res);
    }

    @Override
    public Optional<List<Appointment>> getAppointments() {
        return appointmentRepository.getAppointments();
    }

    @Override
    public Optional<Appointment> getAppointmentByHostAndStart(int hostid, LocalDateTime start) {
        Optional<List<Appointment>> appByStart = appointmentRepository.getAppointmentsByStart(start);
        if (appByStart.isPresent()) {
            for (Appointment a : appByStart.get()) {
                if (a.getHostid() == hostid) {
                    return Optional.of(a);
                }
            }
        }
        return Optional.empty();
    }
}

