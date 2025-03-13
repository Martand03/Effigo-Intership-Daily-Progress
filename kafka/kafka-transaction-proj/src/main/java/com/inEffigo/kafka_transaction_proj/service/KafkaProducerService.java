package com.inEffigo.kafka_transaction_proj.service;

import com.inEffigo.kafka_transaction_proj.entity.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, MasterItem> kafkaTemplate;
    public void sendItemToKafka(MasterItem item,Counter count) {
        kafkaTemplate.send("master-items-topic", item);
        System.out.println("Sent item to Kafka: " + item.getItemName());
        count.counter = count.counter + 1;
    }
}
