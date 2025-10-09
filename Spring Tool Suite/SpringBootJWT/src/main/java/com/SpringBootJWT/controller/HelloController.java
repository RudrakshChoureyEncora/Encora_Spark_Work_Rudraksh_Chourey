package com.SpringBootJWT.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootJWT.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username){
		String token=JwtUtil.generateToken(username);
		System.out.println(token);
		return ResponseEntity.ok("Genrated Token: "+token);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<?> hello(@RequestHeader("Authorization") String token){
		try {
			System.out.println("this is: " +token.replace("Bearer ", ""));
			String username =JwtUtil.validateToken(token.replace("Bearer ", ""));
			return ResponseEntity.ok("Hello, "+username+"! Your token is valid.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(401).body("invalid or expired token!");
		}
	}
}
