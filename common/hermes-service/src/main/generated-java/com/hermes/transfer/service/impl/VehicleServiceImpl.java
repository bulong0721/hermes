package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.Vehicle;
import com.hermes.transfer.dao.VehicleDao;
import com.hermes.transfer.service.VehicleService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class VehicleServiceImpl extends GenericEntityServiceImpl<Long, Vehicle> implements VehicleService {

    protected VehicleDao dao;

    @Autowired
    public VehicleServiceImpl(VehicleDao dao) {
        super(dao);
        this.dao = dao;
    }

}

