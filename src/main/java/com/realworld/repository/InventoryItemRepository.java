package com.realworld.repository;

import com.realworld.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

  boolean existsInventoryItemByTitle(String name);
}
