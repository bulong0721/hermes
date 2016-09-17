package com.hermes.customer.service.impl;

import com.hermes.customer.domain.CustomerAddress;
import com.hermes.customer.dao.CustomerAddressDao;
import com.hermes.customer.service.CustomerAddressService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class CustomerAddressServiceImpl extends GenericEntityServiceImpl<Long, CustomerAddress> implements CustomerAddressService {

    protected CustomerAddressDao dao;

    @Autowired
    public CustomerAddressServiceImpl(CustomerAddressDao dao) {
        super(dao);
        this.dao = dao;
    }

}

