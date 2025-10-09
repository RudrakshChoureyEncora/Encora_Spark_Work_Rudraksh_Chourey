package com.myweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.model.CustomerInfo;
import com.myweb.repository.CustomerInfoRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerInfoRepo cusRepo;
	
	@Override
	public boolean checkuser(String CusId) {
		// TODO Auto-generated method stub
		CustomerInfo cus=cusRepo.findById(CusId).get();
		System.out.println(cus);
		if(cus!=null) return true;
		return false;
	}
	
	@Override
	public boolean checkUserPass(String CusId, String CusPass) {
		// TODO Auto-generated method stub
		CustomerInfo cus=cusRepo.findById(CusId).get();
		System.out.println(cus);
		if(cus.getCustomerpass().equals(CusPass)) return true;
		return false;
	}
}
