package com.myapp.service;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.repository.InvoiceMasterRepo;
import com.myapp.model.InvoiceMaster;

@Service
public class InvoiceMasterService {
	
	@Autowired
	private InvoiceMasterRepo billingdatarepo;
	
	public void insert() {
		InvoiceMaster bt = new InvoiceMaster();
		bt.setBillno(1001);
		bt.setBilldate(new Date());
//		bt.setCustomerid(5001);
		bt.setDiscount(25);
		
		billingdatarepo.save(bt);
	}
}
