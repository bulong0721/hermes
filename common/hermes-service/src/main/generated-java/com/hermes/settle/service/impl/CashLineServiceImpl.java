package com.hermes.settle.service.impl;

import com.hermes.settle.domain.CashLine;
import com.hermes.settle.dao.CashLineDao;
import com.hermes.settle.service.CashLineService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class CashLineServiceImpl extends GenericEntityServiceImpl<Long, CashLine> implements CashLineService {

    protected CashLineDao dao;

    @Autowired
    public CashLineServiceImpl(CashLineDao dao) {
        super(dao);
        this.dao = dao;
    }

}

