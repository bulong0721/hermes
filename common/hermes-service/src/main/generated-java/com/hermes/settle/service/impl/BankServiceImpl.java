package com.hermes.settle.service.impl;

import com.hermes.settle.domain.Bank;
import com.hermes.settle.dao.BankDao;
import com.hermes.settle.service.BankService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class BankServiceImpl extends GenericEntityServiceImpl<Long, Bank> implements BankService {

    protected BankDao dao;

    @Autowired
    public BankServiceImpl(BankDao dao) {
        super(dao);
        this.dao = dao;
    }

}

