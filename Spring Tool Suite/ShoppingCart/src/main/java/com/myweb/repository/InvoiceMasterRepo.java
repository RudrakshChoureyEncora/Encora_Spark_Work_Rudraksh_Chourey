package com.myweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myweb.model.InvoiceMaster;

@Repository
public interface InvoiceMasterRepo extends JpaRepository<InvoiceMaster, String>{

}
