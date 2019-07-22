package com.rajeshbr.kafka.consumerdemo.listener;

import com.rajeshbr.kafka.consumerdemo.model.User;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="demo-topic", groupId="demo-group-1")
    public void consumeString(String message) {
        System.out.println("Consumed string: " + message );
    }

    @KafkaListener(topics = "demo-user-topic", groupId = "user-json-demo-group",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}