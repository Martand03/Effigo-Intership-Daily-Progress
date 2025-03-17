package com.inEffigo.kafka_consumer.controller;

import com.inEffigo.kafka_consumer.repository.ProcessedItemRepository;
import com.inEffigo.kafka_consumer.service.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class MasterItemController {

    private static final Logger logger = LoggerFactory.getLogger(MasterItemController.class);

    private final KafkaConsumerService kafkaConsumerService;
    private final ProcessedItemRepository repository;

    @PostMapping("/consume-and-store")
    public String consumeAndStore() {
        logger.info("Triggering Kafka message consumption and storage...");
        kafkaConsumerService.consumeAndStoreMessages();
        return "Kafka messages consumed and stored in the database.";
    }

}
