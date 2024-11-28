package com.medusa.repository;

import com.medusa.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {
     boolean existsProductCategoriesByName(String name);
}
