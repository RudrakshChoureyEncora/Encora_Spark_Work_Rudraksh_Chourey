package com.myweb.services;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.model.Item;
import com.myweb.repository.ItemRepo;

@Service
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemRepo itRep;
	
	
	@Override
	public List<Item> getShopItems(String shopType) {
		// TODO Auto-generated method stub
		return itRep.findAll().stream()
	            .filter(i -> shopType.equals(i.getShopname()))
	            .collect(Collectors.toList());
	}
}

class myPred implements Predicate<Item>{
	String s;
	public myPred(String s) {
		// TODO Auto-generated constructor stub
		this.s=s;
	}
	
	@Override
	public boolean test(Item t) {
		// TODO Auto-generated method stub
		return !t.getShopname().equals(s);
	}
}
