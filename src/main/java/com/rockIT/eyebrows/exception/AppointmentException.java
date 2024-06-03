package com.rockIT.eyebrows.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class AppointmentException extends RuntimeException {

  public ProblemDetail toProblemDetail() {
    var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

    pb.setTitle("Appointment internal server error");

    return pb;
  }

}
