package com.SpringBootJWT.controller;

import org.springframework.http.ResponseEntity; 
import org.springframework.security.core.Authentication; 
import org.springframework.web.bind.annotation.*;

import com.SpringBootJWT.util.JwtUtil; 

@RestController 
@RequestMapping("/api2") 
public class HelloController2 { 
	 @PostMapping("/login2") 
	 public ResponseEntity<?> login(@RequestParam String username) { 
		 System.out.println("This is called");
		 String token = JwtUtil.generateToken(username); 
		 System.out.println(token);
		 return ResponseEntity.ok("Bearer " + token); 
	 } 
	 @GetMapping("/hello2") 
	 public ResponseEntity<?> hello(Authentication authentication) { 
		 String username = authentication.getName(); 
		 return ResponseEntity.ok("Hello, " + username + "! You are authenticated."); 
	 } 
} 
