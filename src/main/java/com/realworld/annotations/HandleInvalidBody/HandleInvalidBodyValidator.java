package com.realworld.annotations.HandleInvalidBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import java.util.*;

@ControllerAdvice
public class HandleInvalidBodyValidator {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleInvalidBody(
      MethodArgumentNotValidException ex, HandlerMethod handlerMethod) {
    if (handlerMethod.hasMethodAnnotation(HandleInvalidBody.class)) {
      BindingResult bindingResult = ex.getBindingResult();

      Map<String, Object> errors = new HashMap<>();
      errors.put("status", "error");
      Map<String, List<String>> errorDetails = new HashMap<>();

      bindingResult
          .getFieldErrors()
          .forEach(
              fieldError -> {
                System.out.println(
                    fieldError.getField()
                        + " "
                        + fieldError.getRejectedValue()
                        + " "
                        + fieldError.getDefaultMessage());

                var fieldName = fieldError.getField();

                if (errorDetails.containsKey(fieldName)) {
                  errorDetails.get(fieldName).add(fieldError.getDefaultMessage());
                } else {
                  errorDetails.put(
                      fieldName,
                      new ArrayList<>(
                          Arrays.asList(fieldName + " " + fieldError.getDefaultMessage())));
                }
              });

      errors.put("errors", errorDetails);

      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Default handling if annotation is not present
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request body");
  }
}
