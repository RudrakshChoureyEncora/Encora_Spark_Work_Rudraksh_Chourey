package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.myapp.repository.ItemMasterRepo;
import com.myapp.service.CompKeyService;
import com.myapp.service.CustomerMasterService;
import com.myapp.service.InvoiceMasterService;
import com.myapp.service.ItemMasterService;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class BillingSystemApplication {

    private final ItemMasterService itemMasterService;

	private final CustomerMasterService customerMasterService;

	BillingSystemApplication(CustomerMasterService customerMasterService, ItemMasterService itemMasterService) {
		this.customerMasterService = customerMasterService;
		this.itemMasterService = itemMasterService;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BillingSystemApplication.class, args);

		try {
		CompKeyService cks = ctx.getBean(CompKeyService.class);
		cks.insert();
		
		InvoiceMasterService bt = ctx.getBean(InvoiceMasterService.class);
		bt.insert();
		
		CustomerMasterService cms = ctx.getBean(CustomerMasterService.class);
		cms.insert();
		
		ItemMasterService ims = ctx.getBean(ItemMasterService.class);
		ims.insert();
			
		} catch (Exception e) {}
	}

}
