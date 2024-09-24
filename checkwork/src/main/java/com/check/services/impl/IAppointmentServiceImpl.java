package com.check.services.impl;

import com.check.models.Appointment;
import com.check.repositories.JPARepository.AppointmentRepository;
import com.check.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.check.repositories.JPARepository.AppointmentRepository.Specs.*;

@Service
@Primary
public class IAppointmentServiceImpl implements IAppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    /**
     * Lay ra thong tin cuoc hop theo id
     * */
    @Override
    public Optional<Appointment> getAppointmentByAppointmentId(int id) {
        return appointmentRepository.findOne(byId(id));
    }
    /**
     * Lay ra cuoc hop theo ma nguoi to chuc
     * */
    @Override
    public Optional<List<Appointment>> getAppointmentsByHostId(int hostid) {
        return Optional.of(appointmentRepository.findAll(byHostId(hostid)));
    }
    /**
     * Cap nhat cuoc hop
     * */
    @Transactional
    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
    /**
     * Lay ra danh sach nguoi tham gia dua vao ma cuoc hop
     * */
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
    /**
     * Lay ra cac cuoc hop theo ma nguoi tham gia
     * */
    @Override
    public Optional<List<Appointment>> getAppointmentsByJoinId(int joinid) {
        List<Appointment> res = new ArrayList<>();
        Optional<List<Appointment>> appointments = Optional.of(appointmentRepository.findAll());
        appointments.get().stream()
                .filter(appointment -> appointment.getJoinid().contains(String.valueOf(joinid)))
                .forEach(res::add);
        return Optional.of(res);
    }
    /**
     * Lay ra cac cuoc hop theo ten phong
     * */
    @Override
    public List<Appointment> getAppointmentsByRoomName(String name) {
        List<Appointment> appointments = appointmentRepository.findAll(byRoom(name));
        List<Appointment> resAppoints = appointments.stream()
                .filter(appointment -> appointment.getName().equals(name)
                        && appointment.getEnd().isBefore(LocalDateTime.now()))
                .toList();
        return new ArrayList<>(resAppoints);
    }
    /**
     * Lay ra cac cuoc hop
     * */
    @Override
    public Optional<List<Appointment>> getAppointments() {
        return Optional.of(appointmentRepository.findAll());
    }
    /**
     * Lay ra cac cuoc hop trong khoang thoi gian theo ma nguoi to chuc
     * */
    @Override
    public Optional<Appointment> getAppointmentByHostAndStart(int hostid, String time) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime start = LocalDateTime.parse(time, format);
        List<Appointment> appByStart = appointmentRepository.findAll(byStart(start));
        return appByStart.stream().filter(a -> a.getHostid() == hostid).findFirst();
    }
}

