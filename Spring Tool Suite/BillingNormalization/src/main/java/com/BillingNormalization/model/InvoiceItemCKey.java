package com.BillingNormalization.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
@Embeddable // Marks this class as embeddable in another entity
public class InvoiceItemCKey implements Serializable {
    // This corresponds to the inv_id PK and FK column
    @Column(name = "inv_id")
    private Integer invId;
    // This corresponds to the item_no column
    @Column(name = "item_no")
    private Integer itemNo;
    // Constructors
    public InvoiceItemCKey() {
    }
    public InvoiceItemCKey(Integer invId, Integer itemNo) {
        this.invId = invId;
        this.itemNo = itemNo;
    }
    // Getters and Setters
    public Integer getInvId() { return invId; }
    public void setInvId(Integer invId) { this.invId = invId; }
    public Integer getItemNo() { return itemNo; }
    public void setItemNo(Integer itemNo) { this.itemNo = itemNo; }
    // MUST Override equals and hashCode for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItemCKey that = (InvoiceItemCKey) o;
        return Objects.equals(invId, that.invId) && Objects.equals(itemNo, that.itemNo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(invId, itemNo);
    }
}

