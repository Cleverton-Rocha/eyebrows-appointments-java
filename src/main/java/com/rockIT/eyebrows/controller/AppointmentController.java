package com.rockIT.eyebrows.controller;

import com.rockIT.eyebrows.dto.CreateAppointmentDto;
import com.rockIT.eyebrows.model.AppointmentResponse;
import com.rockIT.eyebrows.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping()
  public ResponseEntity<AppointmentResponse> createAppointment(
      @RequestBody @Valid CreateAppointmentDto dto) {
    return ResponseEntity.ok(appointmentService.createAppointment(dto));
  }
}
