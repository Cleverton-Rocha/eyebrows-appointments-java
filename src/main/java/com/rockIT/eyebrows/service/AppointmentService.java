package com.rockIT.eyebrows.service;

import com.rockIT.eyebrows.entity.Appointment;
import com.rockIT.eyebrows.dto.CreateAppointmentDto;
import com.rockIT.eyebrows.exception.HourAndDateAlreadyTakenException;
import com.rockIT.eyebrows.model.AppointmentResponse;
import com.rockIT.eyebrows.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  public AppointmentResponse createAppointment(CreateAppointmentDto dto) {

    if (appointmentRepository.findAppointmentByAppointmentTimeAndAppointmentDate(
        dto.appointmentTime(), dto.appointmentDate()).isPresent()) {
      throw new HourAndDateAlreadyTakenException("There's already an appointment at this time.");
    }

    Appointment NewAppointment = new Appointment();
    NewAppointment.createAppointment(dto);
    appointmentRepository.save(NewAppointment);

    return NewAppointment.toAppointmentResponse();
  }

}
