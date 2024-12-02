package com.medusa.repository;

import com.medusa.entity.ProductCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

  boolean existsProductCategoriesByName(String name);

  @Query("select u FROM ProductCategory u ")
  public List<ProductCategory> getAllCategory();
}
