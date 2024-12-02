package com.realworld;

import com.realworld.DTO.StudentDAO;
import com.realworld.entity.ProductOption;
import com.realworld.entity.ProductOptionValue;
import com.realworld.repository.ProductOptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner comandLIneRunner(
      StudentDAO studentDao, ProductOptionRepository optionRepository) {
    return runner -> {
      ProductOption productOption =
          ProductOption.builder()
              .title("color")
              .productOptionValue(ProductOptionValue.builder().value("blue").build())
              .productOptionValue(ProductOptionValue.builder().value("blue").build())
              .build();

      optionRepository.save(productOption);

      //      createStudent(studentDao);
      //      createProduct(productDAO);
    };
  }

  //  public void createStudent(StudentDAO studentDAO) {
  //    var student = new Student("Sudhanshu", "Kumar", "ggs.sudhanshu@gmail.com");
  //    studentDAO.save(student);
  //  }
  //
  //  public void createProduct(ProductDAO productDAO){
  //    Product product = new Product();
  //    product.status = "variant";
  //    productDAO.save(product);
  //  }

}
