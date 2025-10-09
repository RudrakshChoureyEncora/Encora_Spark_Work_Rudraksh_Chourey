package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.service.KafkaProducer; 
@RestController 
public class KaafkaControler { 
 private final KafkaProducer producer; 
 public KaafkaControler(KafkaProducer producer) { 
 this.producer = producer; 
 } 
 @GetMapping("/send") 
 public String sendMessage(@RequestParam String msg) { 
 producer.sendMessage(msg); 
 return "Message sent: " + msg; 
 } 
} 
