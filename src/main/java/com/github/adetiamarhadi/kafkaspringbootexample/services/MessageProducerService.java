package com.github.adetiamarhadi.kafkaspringbootexample.services;

import com.github.adetiamarhadi.kafkaspringbootexample.dto.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class MessageProducerService {

    @Value(value = "${kafka.topic.name}")
    private String topicName;

    @Autowired
    KafkaTemplate<String, Greeting> kafkaTemplate;

    public void sendMessage(Greeting message) {
        this.kafkaTemplate.send(this.topicName, message);
    }

    public void sendMessageWithCallback(Greeting message) {
        ListenableFuture<SendResult<String, Greeting>> future = this.kafkaTemplate.send(this.topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Greeting>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Unable to send message=[" + message + "] due to : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Greeting> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
        });
    }
}
