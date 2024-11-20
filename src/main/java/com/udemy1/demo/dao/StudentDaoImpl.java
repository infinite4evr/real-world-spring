package com.udemy1.demo.dao;

import org.springframework.stereotype.Repository;

import com.udemy1.demo.entity.Student;

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
