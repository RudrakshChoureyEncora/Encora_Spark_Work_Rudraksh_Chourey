package com.UnitTestingMockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UnitTestingMockito.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{
	
}
