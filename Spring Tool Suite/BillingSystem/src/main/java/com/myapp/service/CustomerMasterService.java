package com.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.model.CustomerMaster;
import com.myapp.repository.CustomerMasterRepo;

@Service
public class CustomerMasterService {

	@Autowired
	private CustomerMasterRepo customermasterrepo;
	
	public void insert() {
		CustomerMaster cm = new CustomerMaster();
		cm.setCustid(5001);
		cm.setCname("Rishabh");
		cm.setCaddress("Noida");
		
		customermasterrepo.save(cm);
	}
	
}
