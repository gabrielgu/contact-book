package com.contactbook.service;

import com.contactbook.model.User;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
    
    @Autowired
    private ContactService service;

    @KafkaListener(topics = "${user.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void deleteContactByUser(ConsumerRecord<String, User> consumerRecord) {
        System.out.println("User: " + consumerRecord.value());
        User user = consumerRecord.value();
        this.service.deleteByIdUser(user.getId());
    }
}
