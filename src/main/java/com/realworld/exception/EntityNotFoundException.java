package com.realworld.exception;

import java.io.Serial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException implements MedusaException {
  @Serial private static final long serialVersionUID = 1L;
  int status = HttpStatus.NOT_FOUND.value();
  String detail = "error occurred";

  public EntityNotFoundException() {
    super();
  }

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String entityName, Long entityId) {
    super(entityName + " with id: " + entityId + " does not exist");
  }

  public EntityNotFoundException(String entityName, String entityIdentifier) {
    super(entityName + " with identifier: \"" + entityIdentifier + "\" does not exist");
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
