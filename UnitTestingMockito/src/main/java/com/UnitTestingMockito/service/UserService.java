package com.UnitTestingMockito.service;

import org.springframework.stereotype.Service;

import com.UnitTestingMockito.model.Users;
import com.UnitTestingMockito.repository.UserRepo;

@Service
public class UserService {
	private final UserRepo userRepository;
	public UserService(UserRepo userRepository) {
		this.userRepository = userRepository;
	}
	
	public String getUserNameById(Long id) {
		return userRepository.findById(id)
				.map(Users::getName)
				.orElse("Unknown");
	}
}
