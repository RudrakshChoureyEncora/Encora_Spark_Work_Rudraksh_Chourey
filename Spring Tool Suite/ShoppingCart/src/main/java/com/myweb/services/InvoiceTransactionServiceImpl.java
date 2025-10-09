package com.myweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.repository.InvoiceTransactionRepo;

@Service
public class InvoiceTransactionServiceImpl {
	
	@Autowired
	private InvoiceTransactionRepo invTranRepo;
	
}
