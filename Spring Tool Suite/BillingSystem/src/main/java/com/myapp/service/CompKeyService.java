package com.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.repository.CompKeyRepo;
import com.myapp.repository.InvoiceMasterRepo;
import com.myapp.repository.ItemMasterRepo;
import com.myapp.model.CompKey;
import com.myapp.model.InvoiceMaster;
import com.myapp.model.ItemMaster;
import com.myapp.model.ItemTransaction;

@Service
public class CompKeyService {
	
	@Autowired
	private CompKeyRepo compkeyrepo;
	
	@Autowired
	private InvoiceMasterRepo invoiceRepo;

	@Autowired
	private ItemMasterRepo itemRepo;
	
	public void insert() {
		CompKey ck = new CompKey();
		ck.setBillno(1001);
		ck.setItemno(104);
		
		ItemTransaction it = new ItemTransaction();
		it.setMyKey(ck);
		it.setQty(300);
		
		InvoiceMaster invoice = invoiceRepo.findById(1001).orElse(null);
		ItemMaster item = itemRepo.findById(2001).orElse(null);
		
		if (invoice != null && item != null) {
			it.setInvoices(invoice);
			it.setItem(item);
			compkeyrepo.save(it);
		} else {
			System.out.println("Invoice or Item not found.");
		}
		
	}
	
	
}
