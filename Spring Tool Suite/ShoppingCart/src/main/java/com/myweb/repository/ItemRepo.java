package com.myweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myweb.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, String>{

}
