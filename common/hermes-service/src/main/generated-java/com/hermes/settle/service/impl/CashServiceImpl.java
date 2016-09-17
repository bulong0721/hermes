package com.hermes.settle.service.impl;

import com.hermes.settle.domain.Cash;
import com.hermes.settle.dao.CashDao;
import com.hermes.settle.service.CashService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class CashServiceImpl extends GenericEntityServiceImpl<Long, Cash> implements CashService {

    protected CashDao dao;

    @Autowired
    public CashServiceImpl(CashDao dao) {
        super(dao);
        this.dao = dao;
    }

}

