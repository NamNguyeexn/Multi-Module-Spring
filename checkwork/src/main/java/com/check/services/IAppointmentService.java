package com.check.services;

import com.check.models.Appointment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface IAppointmentService {
    Optional<Appointment> getAppointmentByAppointmentId(int id);
    Optional<List<Appointment>> getAppointmentsByHostId(int hostid);
    void saveAppointment(Appointment appointment);
    Optional<List<Integer>> getJoinIdsByAppointmentId(int id);
    Optional<List<Appointment>> getAppointmentsByJoinId(int joinid);
    Optional<List<Appointment>> getAppointmentsByRoomName(String name);
    Optional<List<Appointment>> getAppointments();
    Optional<Appointment> getAppointmentByHostAndStart(int hostid, LocalDateTime start);
}
