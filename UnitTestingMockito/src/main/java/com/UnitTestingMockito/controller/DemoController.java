package com.UnitTestingMockito.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UnitTestingMockito.repository.UserRepo;

@RestController
@RequestMapping("/api")
public class DemoController {
//	
//	@Autowired
//	private final UserRepo userRepository;
//
//	public DemoController(UserRepo userRepository) {
//		this.userRepository=userRepository;
//	}
	@GetMapping("/find/{id}")
	public String findUser(@PathVariable Long id) {
		throw new NoSuchElementException("User Missing");
	}
}
