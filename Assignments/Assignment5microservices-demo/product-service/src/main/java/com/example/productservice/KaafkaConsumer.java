package com.example.productservice;

import org.springframework.kafka.annotation.KafkaListener; 
import org.springframework.stereotype.Service; 
@Service 
public class KaafkaConsumer { 
 @KafkaListener(topics = "test", groupId = "hello-group2") 
 public void listen(String message) { 
 System.out.println("Product service..Received message: " + message); 
 } 
} 