package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.model.ItemMaster;

@Repository
public interface ItemMasterRepo extends JpaRepository<ItemMaster, Integer>{

}
