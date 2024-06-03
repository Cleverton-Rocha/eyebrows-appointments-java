package com.rockIT.eyebrows.model;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponse(String name, LocalTime appointmentTime, LocalDate appointmentDate,
                                  String observations, ServiceType serviceType) {

}
