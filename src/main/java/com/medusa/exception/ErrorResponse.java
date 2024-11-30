package com.medusa.exception; // Custom Error Response Class

public class ErrorResponse {

  private int statusCode;
  private String message;
  private String detail;

  public ErrorResponse(int statusCode, String message, String detail) {
    this.statusCode = statusCode;
    this.message = message;
    this.detail = detail;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

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
