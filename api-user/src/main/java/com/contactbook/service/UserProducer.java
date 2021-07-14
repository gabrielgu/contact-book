package com.contactbook.service;

import com.contactbook.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    
    @Value("${user.topic}")
    private String userTopic;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
 
    public void userDeleted(User user) {
        this.kafkaTemplate.send(this.userTopic, user);
    }
    
}
