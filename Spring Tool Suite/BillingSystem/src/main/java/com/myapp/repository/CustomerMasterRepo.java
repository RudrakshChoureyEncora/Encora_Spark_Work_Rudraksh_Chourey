package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.model.CustomerMaster;

@Repository
public interface CustomerMasterRepo extends JpaRepository<CustomerMaster, Integer>{

}
