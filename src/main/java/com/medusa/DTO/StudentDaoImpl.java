package com.medusa.DTO;

import org.springframework.stereotype.Repository;

import com.medusa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDAO {
  private EntityManager entityManager;

  public StudentDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Student theStudent) {
    this.entityManager.persist(theStudent);
  }
}
