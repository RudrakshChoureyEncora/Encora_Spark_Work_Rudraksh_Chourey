package com.myweb.services;

import java.util.List;

import com.myweb.model.Item;

public interface ItemsService {
	public List<Item> getShopItems(String shopType);
}
