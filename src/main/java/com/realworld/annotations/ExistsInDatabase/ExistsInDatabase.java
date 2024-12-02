package com.realworld.annotations.ExistsInDatabase;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsInDatabaseValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsInDatabase {
  String message() default "Record does not exist in the database";

  boolean allowZeroInt() default false;

  Class<?> entity();

  String column();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
