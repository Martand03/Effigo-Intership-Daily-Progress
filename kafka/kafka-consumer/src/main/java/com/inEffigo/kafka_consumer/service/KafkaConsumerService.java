package com.inEffigo.kafka_consumer.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.inEffigo.kafka_consumer.entity.ProcessedItem;
import com.inEffigo.kafka_consumer.repository.ProcessedItemRepository;
import com.inffigo.common.model.MasterItemCommon;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final ProcessedItemRepository processedItemRepository;
    private final ObjectMapper objectMapper;


    @KafkaListener(topics = "master-items-topic", groupId = "master-items-group")
    @Transactional
    public void consumeMasterItem(String message) {
        try{
            ProcessedItem processedItem = objectMapper.readValue(message, ProcessedItem.class);
            processedItemRepository.save(processedItem);
//            logger.info("Message consumed and saved: {}", processedItem.getItemId());
        }catch (Exception e){
            logger.error("Failed to process Kafka message: {}", e.getMessage());
        }
    }

    public void consumeAndStoreMessages() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "master-items-group");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Collections.singletonList("master-item-topic"));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                if (records.isEmpty()) {
                    break;
                }

                for (ConsumerRecord<String, String> record : records) {
                    try {
                        ProcessedItem kafkaItem = objectMapper.readValue(record.value(), ProcessedItem.class);
                        processedItemRepository.save(kafkaItem);
                        logger.info("Message consumed and saved: {}", kafkaItem.getItemId());
                    } catch (Exception e) {
                        logger.error("Failed to process Kafka message: {}", e.getMessage());
                    }
                }
            }
        }
    }
}