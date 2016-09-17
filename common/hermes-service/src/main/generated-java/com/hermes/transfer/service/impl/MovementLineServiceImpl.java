package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.MovementLine;
import com.hermes.transfer.dao.MovementLineDao;
import com.hermes.transfer.service.MovementLineService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class MovementLineServiceImpl extends GenericEntityServiceImpl<Long, MovementLine> implements MovementLineService {

    protected MovementLineDao dao;

    @Autowired
    public MovementLineServiceImpl(MovementLineDao dao) {
        super(dao);
        this.dao = dao;
    }

}

