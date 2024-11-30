package com.medusa.repository;

import com.medusa.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    boolean existsProductTypeByValue(String value);
}
