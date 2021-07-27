package com.github.adetiamarhadi.kafkaspringbootexample.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerService {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.groupid.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        System.out.println("Received Message in group 'grp': " + message);
    }
}
