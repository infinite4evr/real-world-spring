package com.realworld.repository;

import com.realworld.entity.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Long> {
  boolean existsProductTagsByValue(String value);
}
