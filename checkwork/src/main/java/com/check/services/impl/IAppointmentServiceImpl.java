package com.check.services.impl;

import com.check.models.Appointment;
import com.check.repositories.JPARepository.AppointmentRepository;
import com.check.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.check.repositories.JPARepository.AppointmentRepository.Specs.*;

@Service
public class IAppointmentServiceImpl implements IAppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Optional<Appointment> getAppointmentByAppointmentId(int id) {
        return appointmentRepository.findOne(byId(id));
    }

    @Override
    public Optional<List<Appointment>> getAppointmentsByHostId(int hostid) {
        return Optional.of(appointmentRepository.findAll(byHostId(hostid)));
    }
    @Transactional
    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Optional<List<Integer>> getJoinIdsByAppointmentId(int id) {
        List<Integer> joins = new ArrayList<>();
        Optional<Appointment> appointmentOptional = appointmentRepository.findOne(byId(id));
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
        List<Appointment> res = new ArrayList<>();
        Optional<List<Appointment>> appointments = Optional.of(appointmentRepository.findAll());
        for (Appointment a : appointments.get()){
            if (a.getJoinid().contains(String.valueOf(joinid))){
                res.add(a);
            }
        }
        return Optional.of(res);
    }

    @Override
    public List<Appointment> getAppointmentsByRoomName(String name) {
        List<Appointment> res = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findAll(byRoom(name));
        if (!appointments.isEmpty()) {
            for(Appointment a : appointments) {
                if(a.getName().equals(name) && a.getEnd().isBefore(LocalDateTime.now())){
                    res.add(a);
                }
            }
        }
        return res;
    }

    @Override
    public Optional<List<Appointment>> getAppointments() {
        return Optional.of(appointmentRepository.findAll());
    }

    @Override
    public Optional<Appointment> getAppointmentByHostAndStart(int hostid, String time) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime start = LocalDateTime.parse(time, format);
        List<Appointment> appByStart = appointmentRepository.findAll(byStart(start));
        if (!appByStart.isEmpty()) {
            for (Appointment a : appByStart) {
                if (a.getHostid() == hostid) {
                    return Optional.of(a);
                }
            }
        }
        return Optional.empty();
    }
}

