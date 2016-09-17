package com.hermes.customer.service.impl;

import com.hermes.customer.domain.CustomerPhone;
import com.hermes.customer.dao.CustomerPhoneDao;
import com.hermes.customer.service.CustomerPhoneService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class CustomerPhoneServiceImpl extends GenericEntityServiceImpl<Long, CustomerPhone> implements CustomerPhoneService {

    protected CustomerPhoneDao dao;

    @Autowired
    public CustomerPhoneServiceImpl(CustomerPhoneDao dao) {
        super(dao);
        this.dao = dao;
    }

}

