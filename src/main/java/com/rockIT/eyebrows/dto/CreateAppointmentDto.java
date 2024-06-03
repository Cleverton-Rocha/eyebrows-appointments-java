package com.rockIT.eyebrows.dto;

import com.rockIT.eyebrows.model.ServiceType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

public record CreateAppointmentDto(

    @NotBlank
    @Size(min = 1, max = 50)
    String name,

    @NotNull
    @FutureOrPresent
    LocalTime appointmentTime,

    @NotNull
    @FutureOrPresent
    LocalDate appointmentDate,

    @Size(max = 150)
    String observations,

    @NotNull
    ServiceType serviceType) {

}
