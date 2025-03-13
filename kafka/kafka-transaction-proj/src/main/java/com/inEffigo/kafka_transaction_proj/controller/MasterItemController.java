package com.inEffigo.kafka_transaction_proj.controller;

import com.inEffigo.kafka_transaction_proj.entity.MasterItem;
import com.inEffigo.kafka_transaction_proj.repository.MasterItemRepository;
import com.inEffigo.kafka_transaction_proj.service.Counter;
import com.inEffigo.kafka_transaction_proj.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class MasterItemController {

    private final MasterItemRepository repository;
    private final KafkaProducerService kafkaProducer;

    @GetMapping("/send")
    public String sendItemsToKafka() {
        List<MasterItem> items = repository.findAll();

        Counter count = new Counter();
        items.forEach(item->{
            kafkaProducer.sendItemToKafka(item,count);
        });

        return "Sent " +  count.getCounter() + " items to Kafka!";
    }
}

