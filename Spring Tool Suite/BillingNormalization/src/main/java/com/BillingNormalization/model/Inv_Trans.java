package com.BillingNormalization.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "inv_trans")
public class Inv_Trans {

    // Composite primary key using the embedded class
    @EmbeddedId
    private InvoiceItemCKey id = new InvoiceItemCKey(); // Initialize to avoid NPE

    // Many-to-One relationship: Many transactions belong to one InvoiceMaster
    // This is the owning side of the relationship.
    // This 'inv_id' column is both part of the PK and the FK.
    @MapsId("invId") // Tells JPA to use the 'invId' field from the embedded ID as the FK.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_id", referencedColumnName = "inv_id", insertable = false, updatable = false)
    private Invoice_Master invMaster;

    // The rest of the columns are simple fields
    @Column(name = "item_description", nullable = false, length = 255)
    private String itemDescription;

    @Column(name = "quantity", nullable = false, precision = 10, scale = 2)
    private Double quantity;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private Double unitPrice;

    @Column(name = "line_total", nullable = false, precision = 10, scale = 2)
    private Double lineTotal;

    // Constructors
    public Inv_Trans() {
    }

    // Convenience constructor
    public Inv_Trans(Integer itemNo, String itemDescription, Double quantity, Double unitPrice) {
        this.id.setItemNo(itemNo);
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.lineTotal = quantity * unitPrice; // Calculate line total
    }

    // Helper getters to easily access parts of the composite key
    public Integer getInvId() {
        return this.id.getInvId();
    }

    public Integer getItemNo() {
        return this.id.getItemNo();
    }

    // Getters and Setters
    public InvoiceItemCKey getId() { return id; }
    public void setId(InvoiceItemCKey id) { this.id = id; }

    public Invoice_Master getInvMaster() { return invMaster; }
    public void setInvMaster(Invoice_Master invMaster) {
        this.invMaster = invMaster;
        // Also sync the invId in the composite key when setting the relationship
        if (invMaster != null) {
            this.id.setInvId(invMaster.getInvId());
        }
    }

    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
        this.calculateLineTotal(); // Recalculate if quantity changes
    }

    public Double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        this.calculateLineTotal(); // Recalculate if unitPrice changes
    }

    public Double getLineTotal() { return lineTotal; }
    public void setLineTotal(Double lineTotal) { this.lineTotal = lineTotal; }

    // Business logic to calculate the line total
    private void calculateLineTotal() {
        if (this.quantity != null && this.unitPrice != null) {
            this.lineTotal = this.quantity * this.unitPrice;
        }
    }
}