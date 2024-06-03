package com.rockIT.eyebrows.repository;

import com.rockIT.eyebrows.entity.Appointment;
import com.rockIT.eyebrows.model.AppointmentResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  Optional<Appointment> findAppointmentByAppointmentTimeAndAppointmentDate(
      LocalTime appointmentTime, LocalDate appointmentDate);
}
