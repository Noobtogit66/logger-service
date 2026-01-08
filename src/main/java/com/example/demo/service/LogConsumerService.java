package com.example.demo.service;

import com.example.demo.model.Applog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogConsumerService {

    @KafkaListener(
        topics = "attendance",
        groupId = "log-consumer-group",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(Applog logData) {
        log.info("Received Log: {}",
                 logData.toString());
        
        // Your logic here (e.g., save to DB or send to ELK)
    }
}