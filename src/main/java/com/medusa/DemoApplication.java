package com.medusa;

import com.medusa.DTO.ProductDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.medusa.DTO.StudentDAO;
import com.medusa.entity.Student;
import com.medusa.model.Product;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner comandLIneRunner(StudentDAO studentDao, ProductDAO productDAO) {
    return runner -> {
      createStudent(studentDao);
      createProduct(productDAO);



    };
  }

  public void createStudent(StudentDAO studentDAO) {
    var student = new Student("Sudhanshu", "Kumar", "ggs.sudhanshu@gmail.com");
    studentDAO.save(student);
  }

  public void createProduct(ProductDAO productDAO){
    Product product = new Product();
    product.status = "variant";
    productDAO.save(product);
  }

}
