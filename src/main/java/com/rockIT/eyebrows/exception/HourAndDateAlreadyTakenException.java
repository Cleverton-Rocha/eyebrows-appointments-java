package com.rockIT.eyebrows.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class HourAndDateAlreadyTakenException extends AppointmentException {

  private String detail;

  public HourAndDateAlreadyTakenException(String detail) {
    this.detail = detail;
  }

  @Override
  public ProblemDetail toProblemDetail() {
    var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

    pb.setTitle("Hour and date already taken.");
    pb.setDetail(detail);

    return pb;
  }
}
