//package com.myapp.model;
//
//import jakarta.persistence.EmbeddedId;
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class ItemTransaction {
//	
//	//Composite key
//	@EmbeddedId
//	private CompKey myKey;
//	private int qty;
//	
//	@ManyToOne
//	@JoinColumn(name = "billno")
//	private InvoiceMaster invoices;
//	
//	@ManyToOne
//	@JoinColumn(name = "itemno")
//	private ItemMaster item;
//	
//	public InvoiceMaster getInvoices() {
//		return invoices;
//	}
//	public void setInvoices(InvoiceMaster invoices) {
//		this.invoices = invoices;
//	}
//	public ItemMaster getItem() {
//		return item;
//	}
//	public void setItem(ItemMaster item) {
//		this.item = item;
//	}
//	public CompKey getMyKey() {
//		return myKey;
//	}
//	public void setMyKey(CompKey myKey) {
//		this.myKey = myKey;
//	}
//	public int getQty() {
//		return qty;
//	}
//	public void setQty(int qty) {
//		this.qty = qty;
//	}
//}


package com.myapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemTransaction {

    // Composite key
    @EmbeddedId
    private CompKey myKey;

    private int qty;

    @ManyToOne
    @JoinColumn(name = "billno", insertable = false, updatable = false)
    private InvoiceMaster invoices;

    @ManyToOne
    @JoinColumn(name = "itemno", insertable = false, updatable = false)
    private ItemMaster item;

    // Getters and setters
    public CompKey getMyKey() {
        return myKey;
    }

    public void setMyKey(CompKey myKey) {
        this.myKey = myKey;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public InvoiceMaster getInvoices() {
        return invoices;
    }

    public void setInvoices(InvoiceMaster invoices) {
        this.invoices = invoices;
    }

    public ItemMaster getItem() {
        return item;
    }

    public void setItem(ItemMaster item) {
        this.item = item;
    }
}
