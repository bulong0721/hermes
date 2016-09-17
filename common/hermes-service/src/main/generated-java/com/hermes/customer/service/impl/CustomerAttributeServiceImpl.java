package com.hermes.customer.service.impl;

import com.hermes.customer.domain.CustomerAttribute;
import com.hermes.customer.dao.CustomerAttributeDao;
import com.hermes.customer.service.CustomerAttributeService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class CustomerAttributeServiceImpl extends GenericEntityServiceImpl<Long, CustomerAttribute> implements CustomerAttributeService {

    protected CustomerAttributeDao dao;

    @Autowired
    public CustomerAttributeServiceImpl(CustomerAttributeDao dao) {
        super(dao);
        this.dao = dao;
    }

}

