package com.BillingNormalization.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_master")
public class Invoice_Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @Column(name = "inv_id")
    private Integer invId;

    @Column(name = "inv_date", nullable = false)
    private LocalDate invDate;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "customer_address", columnDefinition = "TEXT")
    private String customerAddress;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private Double totalAmount;

    @Column(name = "tax_amount", precision = 10, scale = 2)
    private Double taxAmount;

    @Column(columnDefinition = "TEXT")
    private String notes;

    // One-to-Many relationship: One InvoiceMaster has many InvoiceTransactions
    // mappedBy="invMaster" refers to the 'invMaster' field in the InvTransaction class.
    // CascadeType.ALL ensures operations (like persist) are cascaded to transactions.
    @OneToMany(mappedBy = "invMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inv_Trans> transactions;

    // Constructors
    public Invoice_Master() {
    }

    // Convenience method to add a transaction and set the bidirectional relationship
    public void addTransaction(Inv_Trans transaction) {
        this.transactions.add(transaction);
        transaction.setInvMaster(this);
    }

    // Getters and Setters
    public Integer getInvId() { return invId; }
    public void setInvId(Integer invId) { this.invId = invId; }

    public LocalDate getInvDate() { return invDate; }
    public void setInvDate(LocalDate invDate) { this.invDate = invDate; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(Double taxAmount) { this.taxAmount = taxAmount; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public List<Inv_Trans> getTransactions() { return transactions; }
    public void setTransactions(List<Inv_Trans> transactions) { this.transactions = transactions; }
}
