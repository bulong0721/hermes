package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.Inout;
import com.hermes.transfer.dao.InoutDao;
import com.hermes.transfer.service.InoutService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class InoutServiceImpl extends GenericEntityServiceImpl<Long, Inout> implements InoutService {

    protected InoutDao dao;

    @Autowired
    public InoutServiceImpl(InoutDao dao) {
        super(dao);
        this.dao = dao;
    }

}

