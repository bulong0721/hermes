package com.hermes.settle.service.impl;

import com.hermes.settle.domain.BankAccount;
import com.hermes.settle.dao.BankAccountDao;
import com.hermes.settle.service.BankAccountService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class BankAccountServiceImpl extends GenericEntityServiceImpl<Long, BankAccount> implements BankAccountService {

    protected BankAccountDao dao;

    @Autowired
    public BankAccountServiceImpl(BankAccountDao dao) {
        super(dao);
        this.dao = dao;
    }

}

