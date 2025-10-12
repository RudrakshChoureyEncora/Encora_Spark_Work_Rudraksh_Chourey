package com.assignment4b.controller;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse; 
@RestController 
@RequestMapping("/api/hello") 
public class HelloController { 
 @GetMapping 
 @Operation(summary = "Say Hello", description = "Returns a greeting message") 
  @ApiResponse(responseCode = "200", description = "Successful greeting") 
 public String sayHello() { 
 return "Hello, Swagger!"; 
 } 
 @GetMapping("/{name}") 
 public String greetByName(@PathVariable String name) { 
 return "Hello, " + name + "!"; 
 } 
} 
