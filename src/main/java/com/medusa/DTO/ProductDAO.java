package com.medusa.DTO;

import com.medusa.model.Product;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProductDAO   {
    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Product product) {
        this.entityManager.persist(product);
    }
}
