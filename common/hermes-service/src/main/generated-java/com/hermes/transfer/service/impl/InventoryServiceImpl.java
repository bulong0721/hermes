package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.Inventory;
import com.hermes.transfer.dao.InventoryDao;
import com.hermes.transfer.service.InventoryService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class InventoryServiceImpl extends GenericEntityServiceImpl<Long, Inventory> implements InventoryService {

    protected InventoryDao dao;

    @Autowired
    public InventoryServiceImpl(InventoryDao dao) {
        super(dao);
        this.dao = dao;
    }

}

