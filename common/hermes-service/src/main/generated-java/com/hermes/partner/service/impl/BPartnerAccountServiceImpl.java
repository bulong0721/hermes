package com.hermes.partner.service.impl;

import com.hermes.partner.domain.BPartnerAccount;
import com.hermes.partner.dao.BPartnerAccountDao;
import com.hermes.partner.service.BPartnerAccountService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class BPartnerAccountServiceImpl extends GenericEntityServiceImpl<Long, BPartnerAccount> implements BPartnerAccountService {

    protected BPartnerAccountDao dao;

    @Autowired
    public BPartnerAccountServiceImpl(BPartnerAccountDao dao) {
        super(dao);
        this.dao = dao;
    }

}

