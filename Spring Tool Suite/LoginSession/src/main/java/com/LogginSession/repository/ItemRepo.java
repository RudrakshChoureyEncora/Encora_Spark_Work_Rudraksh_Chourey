package com.LogginSession.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LogginSession.model.Item;



public interface ItemRepo extends JpaRepository<Item, String>{

	List<Item> findByShopid(String shopid);
}
