package com.ShoppingDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingDemo.model.Item;
import com.ShoppingDemo.repository.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepo iRep;

	@Override
	public List<Item> getShopItem(String shopName) {
		// TODO Auto-generated method stub
		return iRep.findAll().stream().filter(a->a.getShopid().equals(shopName)).toList();
	}
}
