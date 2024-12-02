package com.realworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator {

  @ExceptionHandler({GeneralException.class, EntityNotFoundException.class})
  public ResponseEntity handleError(MedusaException e) {
    return ResponseEntity.status(400)
        .body(new ErrorResponse(e.getStatus(), e.getMessage(), e.getDetail()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleError(Exception e) {
    return ResponseEntity.status(400)
        .body(
            new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getMessage()));
  }
}
