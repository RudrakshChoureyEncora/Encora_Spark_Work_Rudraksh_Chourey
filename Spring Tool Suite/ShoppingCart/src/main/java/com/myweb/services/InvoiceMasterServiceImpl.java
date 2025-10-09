package com.myweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.repository.InvoiceMasterRepo;

@Service
public class InvoiceMasterServiceImpl {
	
	@Autowired
	private InvoiceMasterRepo invMasRep;
	
}
