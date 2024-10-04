package com.kafka.service;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message){
//        kafkaTemplate.send(topic, message);
        for(int i=0;i<10;i++){

            for(int j=0;j<10;j++){
                String msg = "message"+i;
                String key = Integer.toString(j);
                CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic,key,msg);

                future.whenComplete( ( result,  ex)->{
                    if(ex == null){
                        RecordMetadata metadata = result.getRecordMetadata();
//                        logger.info("Message sent successfully!");
                        logger.info("Key: {}, Partition: {}" , key, metadata.partition());
//                        logger.info("Topic: {}" , metadata.topic());
//                        logger.info("Partition: {}", metadata.partition());
//                        logger.info("Offset: {}" , metadata.offset());
                    }
                    else{
                        logger.error("Error during message producing: {}", ex.getMessage());
                    }
                });
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
