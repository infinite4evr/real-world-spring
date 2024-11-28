package com.medusa.annotations.ExistsInDatabase;

import com.medusa.annotations.ExistsInDatabase.ExistsInDatabase;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class ExistsInDatabaseValidator implements ConstraintValidator<ExistsInDatabase, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entity;
    private String column;

    private boolean allowZeroInt;

    @Override
    public void initialize(ExistsInDatabase constraintAnnotation) {
        this.entity = constraintAnnotation.entity();
        this.column = constraintAnnotation.column();
        this.allowZeroInt = constraintAnnotation.allowZeroInt();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (allowZeroInt && value instanceof Integer && value.equals(0)) {
           return true;
        }

        if (value == null) {
            return true;
        }

        try {
            String query = String.format("SELECT COUNT(e) FROM %s e WHERE e.%s = :value", entity.getSimpleName(), column);
            Long count = (Long) entityManager.createQuery(query)
                    .setParameter("value", value)
                    .getSingleResult();


            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
