package com.hermes.partner.service.impl;

import com.hermes.partner.domain.BPartner;
import com.hermes.partner.dao.BPartnerDao;
import com.hermes.partner.service.BPartnerService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class BPartnerServiceImpl extends GenericEntityServiceImpl<Long, BPartner> implements BPartnerService {

    protected BPartnerDao dao;

    @Autowired
    public BPartnerServiceImpl(BPartnerDao dao) {
        super(dao);
        this.dao = dao;
    }

}

