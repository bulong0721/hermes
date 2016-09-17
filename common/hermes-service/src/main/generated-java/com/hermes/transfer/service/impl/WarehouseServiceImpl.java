package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.Warehouse;
import com.hermes.transfer.dao.WarehouseDao;
import com.hermes.transfer.service.WarehouseService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class WarehouseServiceImpl extends GenericEntityServiceImpl<Long, Warehouse> implements WarehouseService {

    protected WarehouseDao dao;

    @Autowired
    public WarehouseServiceImpl(WarehouseDao dao) {
        super(dao);
        this.dao = dao;
    }

}

