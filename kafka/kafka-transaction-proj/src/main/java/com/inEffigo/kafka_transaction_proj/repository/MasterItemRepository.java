package com.inEffigo.kafka_transaction_proj.repository;

import com.inEffigo.kafka_transaction_proj.entity.MasterItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterItemRepository extends JpaRepository<MasterItem, Long> {
}
