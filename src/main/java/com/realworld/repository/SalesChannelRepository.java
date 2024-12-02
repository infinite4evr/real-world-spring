package com.realworld.repository;

import com.realworld.entity.SalesChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesChannelRepository extends JpaRepository<SalesChannel, Long> {
  boolean existsSalesChannelByName(String value);
}
