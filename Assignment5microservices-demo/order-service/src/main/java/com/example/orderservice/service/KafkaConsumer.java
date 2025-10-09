package com.example.orderservice.service;

import org.springframework.kafka.annotation.KafkaListener; 
import org.springframework.stereotype.Service; 
@Service 
public class KafkaConsumer { 
 @KafkaListener(topics = "test", groupId = "hello-group1") 
 public void listen(String message) { 
 System.out.println("Received message: " + message); 
 } 
} 