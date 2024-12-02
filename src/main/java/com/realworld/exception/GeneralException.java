package com.realworld.exception;

import java.io.Serial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralException extends RuntimeException implements MedusaException {

  @Serial private static final long serialVersionUID = 1L;
  public int status = HttpStatus.BAD_REQUEST.value();
  public String message = "some error occurred";
  public String detail = "some error occurred";

  public GeneralException() {
    super();
  }

  public GeneralException(String message) {
    this(message, message);
  }

  public GeneralException(String message, String detail) {
    super(message);
    this.message = message;
    this.detail = detail;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
