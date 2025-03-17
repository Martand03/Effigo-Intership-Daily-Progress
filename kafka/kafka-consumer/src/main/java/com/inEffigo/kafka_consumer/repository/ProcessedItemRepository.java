package com.inEffigo.kafka_consumer.repository;


import com.inEffigo.kafka_consumer.entity.ProcessedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedItemRepository extends JpaRepository<ProcessedItem, String> {

}
