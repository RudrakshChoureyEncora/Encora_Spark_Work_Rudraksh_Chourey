package com.ShoppingDemo.service;

import java.util.List;

import com.ShoppingDemo.model.Item;


public interface ItemService {
	public List<Item> getShopItem(String shopName);
}
