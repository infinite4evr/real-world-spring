package com.udemy1.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.udemy1.demo.dao.StudentDAO;
import com.udemy1.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner comandLIneRunner(StudentDAO studentDao) {
    return runner -> {
      createStudent(studentDao);

    };
  }

  public void createStudent(StudentDAO studentDAO) {
    var student = new Student("Sudhanshu", "Kumar", "ggs.sudhanshu@gmail.com");
    studentDAO.save(student);
  }

}
