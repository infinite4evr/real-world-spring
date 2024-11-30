package com.medusa.repository;

import com.medusa.entity.SalesChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesChannelRepository extends JpaRepository<SalesChannel, Long> {
    boolean existsSalesChannelByName(String value);
}
