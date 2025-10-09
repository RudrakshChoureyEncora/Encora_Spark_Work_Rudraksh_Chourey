package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.model.InvoiceMaster;

@Repository
public interface InvoiceMasterRepo extends JpaRepository<InvoiceMaster, Integer>{

}
