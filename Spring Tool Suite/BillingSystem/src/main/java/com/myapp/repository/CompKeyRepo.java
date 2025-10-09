package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.model.CompKey;
import com.myapp.model.ItemTransaction;

@Repository
public interface CompKeyRepo extends JpaRepository<ItemTransaction, CompKey> {
	
}
