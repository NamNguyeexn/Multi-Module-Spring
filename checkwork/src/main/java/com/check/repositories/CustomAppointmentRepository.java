package com.check.repositories;

import com.check.models.Appointment;
import com.check.repositories.JPARepository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
//@EnableJpaRepositories(basePackages = {"com.check.repositories.JPARepository.AppointmentRepository"})
public class CustomAppointmentRepository {
    @Autowired
    private AppointmentRepository appointmentRepository;
    public Optional<List<Appointment>> getAppointmentsByHostId(int hostid) {
        return Optional.of(appointmentRepository.findAll(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("hostid"), hostid)
        ));
    }
    public Optional<Appointment> getAppointmentByAppointmentId(int id) {
        return appointmentRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("id"), id)
        );
    }
    public Optional<List<Appointment>> getAppointments (){
        return Optional.of(appointmentRepository.findAll());
    }

    @Transactional
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
    public Optional<List<Appointment>> getAppointmentsByRoom(String room) {
        return Optional.of(appointmentRepository.findAll(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("room"), room)
        ));
    }
    public Optional<List<Appointment>> getAppointmentsByStart(LocalDateTime start) {
        return Optional.of(appointmentRepository.findAll(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("start"), start)
        ));
    }
}
