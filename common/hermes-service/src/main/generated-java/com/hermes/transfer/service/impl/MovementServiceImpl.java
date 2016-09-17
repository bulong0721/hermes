package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.Movement;
import com.hermes.transfer.dao.MovementDao;
import com.hermes.transfer.service.MovementService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class MovementServiceImpl extends GenericEntityServiceImpl<Long, Movement> implements MovementService {

    protected MovementDao dao;

    @Autowired
    public MovementServiceImpl(MovementDao dao) {
        super(dao);
        this.dao = dao;
    }

}

