package com.myweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myweb.model.CompKey;
import com.myweb.model.InvoiceTransaction;

@Repository
public interface InvoiceTransactionRepo extends JpaRepository<InvoiceTransaction, CompKey>{

}
