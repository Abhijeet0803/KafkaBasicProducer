package com.kafka.controller;

import com.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class KafkaProducerController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(){
        kafkaProducerService.sendMessage("user-topic", "124455");
        return ResponseEntity.ok("Message Sent Successfully");
    }
}
