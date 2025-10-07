package com.UnitTestingMockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UnitTestingMockito.model.Users;
import com.UnitTestingMockito.repository.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private final UserRepo userRepository;

	public UserController(UserRepo userRepository) {
		this.userRepository=userRepository;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUser(@PathVariable Long id) {
		ResponseEntity<Users> rs=userRepository.findById(id)
		.map(ResponseEntity::ok)
		.orElse(ResponseEntity.notFound().build()) ;
		
		return rs;
	}
}
