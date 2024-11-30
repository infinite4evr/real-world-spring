package com.medusa.repository;

import com.medusa.entity.ProductCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCollectionRepository extends JpaRepository<ProductCollection, Long> {
  boolean existsProductCollectionByTitle(String value);
}
