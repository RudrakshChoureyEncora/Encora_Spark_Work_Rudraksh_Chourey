package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("BRC")
public class BasicRestController {
	
	@GetMapping("/hitGet")
	public String getMethodName() {
		System.out.println("this is running");
		return new String();
	}
	
}





