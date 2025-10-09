package com.ShoppingDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingDemo.model.Item;


public interface ItemRepo extends JpaRepository<Item, String>{

}
