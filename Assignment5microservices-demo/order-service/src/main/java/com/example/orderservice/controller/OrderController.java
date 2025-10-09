package com.example.orderservice.controller;

import com.example.orderservice.client.ProductServiceClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductServiceClient productServiceClient;
    
   
    
    @GetMapping
    @Operation(summary ="Returns all the orders from the database")
    public List<Order> getAllOrders() {
    	return orderRepository.findAll();
    }
    
    @PostMapping
    @Operation(summary = "creates a order and saves it in database")
    public Order createOrder(@RequestBody Order order) {
    	return orderRepository.save(order);
    }
    
    
    @GetMapping("/createorder")
    @Operation(summary = "creates a sample order")
    public Order createSampleOrder() {
    	Order order = new Order();
    	order.setId(1);
    	return orderRepository.save(order);
    }
    
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
       return orderRepository.findById(id).get();
    }
    
    @GetMapping("/getprod/{id}")
    public Object getProduct(@PathVariable Long id) {
    	return productServiceClient.getProductById(id);
    }
    
    
    
  
}






