package com.LogginSession.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LogginSession.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
