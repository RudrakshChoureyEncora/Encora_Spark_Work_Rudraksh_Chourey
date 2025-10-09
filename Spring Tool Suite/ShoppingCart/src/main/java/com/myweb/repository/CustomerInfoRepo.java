package com.myweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myweb.model.CustomerInfo;

@Repository
public interface CustomerInfoRepo extends JpaRepository<CustomerInfo, String>{
	

}
