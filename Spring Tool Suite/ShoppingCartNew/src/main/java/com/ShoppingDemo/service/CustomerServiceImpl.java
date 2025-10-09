package com.ShoppingDemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingDemo.model.Customer;
import com.ShoppingDemo.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo cusRepo;
	
	
	@Override
	public boolean checkUser(String cusId) {
		// TODO Auto-generated method stub
		Optional<Customer> cus=cusRepo.findById(cusId);
		if(cus.isEmpty())return false;
		return true;
	}
	
	@Override
	public boolean checkUserPass(String cusId, String cusPass) {
		// TODO Auto-generated method stub
		Optional<Customer> cusOp=cusRepo.findById(cusId);
		if(cusOp.isEmpty())return false;
		if(cusOp.get().getCustomerpass().equals(cusPass)) return true;
		return false;
	}
	
	@Override
	public boolean checkUserFlag(String cusId) {
		// TODO Auto-generated method stub
		Optional<Customer> cusOp=cusRepo.findById(cusId);
		if(cusOp.isEmpty())return false;
        return cusOp.get().isIscustomerloggedin();
	}
}
