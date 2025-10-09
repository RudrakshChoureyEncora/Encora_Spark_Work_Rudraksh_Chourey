package com.SpringBootSec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BRC {
	@GetMapping("/hello")
	public String hello() {
		System.out.println("this is called");
		return "Hello is Called..!!!";
	}
}
