package com.assignment3.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment3.util.JwtUtil;

@RestController 
public class HelloController { 
	
	@GetMapping("/api/login")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String role){
		System.out.println("thyis is called");
		String token=JwtUtil.generateToken(username,List.of(role));
		System.out.println(token);
		return ResponseEntity.ok("Bearer "+token);
	}
	
	
	 @GetMapping("/api/hello") 
	 public String hello(Authentication auth) { 
		 return "Hello, " + auth.getName() + "! You are authenticated."; 
	 } 
	 @GetMapping("/api/admin") 
	 public String admin(Authentication auth) { 
		 return "Welcome Admin, " + auth.getName() + "! You have special access."; 
	 } 
} 


