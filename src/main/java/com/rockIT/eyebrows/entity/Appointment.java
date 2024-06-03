package com.rockIT.eyebrows.entity;

import com.rockIT.eyebrows.dto.CreateAppointmentDto;
import com.rockIT.eyebrows.model.AppointmentResponse;
import com.rockIT.eyebrows.model.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "appointment_time")
  private LocalTime appointmentTime;

  @Column(name = "appointment_date")
  private LocalDate appointmentDate;

  @Column(name = "observations")
  private String observations;

  @Enumerated(EnumType.STRING)
  @Column(name = "service_type")
  private ServiceType serviceType;

  public Appointment() {
  }

  public Appointment(Long id, String name, LocalTime appointmentTime, LocalDate appointmentDate,
      String observations, ServiceType serviceType) {
    this.id = id;
    this.name = name;
    this.appointmentTime = appointmentTime;
    this.appointmentDate = appointmentDate;
    this.observations = observations;
    this.serviceType = serviceType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalTime getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(LocalTime appointmentTime) {
    this.appointmentTime = appointmentTime;
  }

  public LocalDate getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(LocalDate appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public String getObservations() {
    return observations;
  }

  public void setObservations(String observations) {
    this.observations = observations;
  }

  public ServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  public void createAppointment(CreateAppointmentDto dto) {
    this.setName(dto.name());
    this.setAppointmentTime(dto.appointmentTime());
    this.setAppointmentDate(dto.appointmentDate());
    this.setServiceType(dto.serviceType());
    if (dto.observations() == null || dto.observations().isEmpty()) {
      this.setObservations("Sem observações.");
    } else {
      this.setObservations(dto.observations());
    }
  }

  public AppointmentResponse toAppointmentResponse() {
    return new AppointmentResponse(this.getName(), this.getAppointmentTime(),
        this.getAppointmentDate(),
        this.getObservations(), this.getServiceType());
  }
}