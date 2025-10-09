package com.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.model.ItemMaster;
import com.myapp.repository.ItemMasterRepo;

@Service
public class ItemMasterService {

    @Autowired
    private ItemMasterRepo itemMasterRepo;

    public void insert() {
        // Create an ItemMaster object
        ItemMaster item = new ItemMaster();
        item.setItemno(2001);
        item.setDescription("Dairy Item..");
        item.setPrice(31.0f);

        // Save it to the database
        itemMasterRepo.save(item);
    }
}
