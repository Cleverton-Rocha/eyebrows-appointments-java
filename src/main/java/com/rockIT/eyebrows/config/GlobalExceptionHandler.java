package com.rockIT.eyebrows.config;

import com.rockIT.eyebrows.exception.AppointmentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AppointmentException.class)
  public ProblemDetail handleAppointmentException(AppointmentException e) {
    return e.toProblemDetail();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

    var fieldErrors = e.getFieldErrors()
        .stream()
        .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
        .toList();

    var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    pb.setTitle("Your request parameters didn't validate.");
    pb.setProperty("invalid-params", fieldErrors);

    return pb;
  }

  private record InvalidParam(String name, String reason) {

  }

}
