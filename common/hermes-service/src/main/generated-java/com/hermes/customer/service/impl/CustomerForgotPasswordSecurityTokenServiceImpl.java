package com.hermes.customer.service.impl;

import com.hermes.customer.domain.CustomerForgotPasswordSecurityToken;
import com.hermes.customer.dao.CustomerForgotPasswordSecurityTokenDao;
import com.hermes.customer.service.CustomerForgotPasswordSecurityTokenService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class CustomerForgotPasswordSecurityTokenServiceImpl extends GenericEntityServiceImpl<String, CustomerForgotPasswordSecurityToken> implements CustomerForgotPasswordSecurityTokenService {

    protected CustomerForgotPasswordSecurityTokenDao dao;

    @Autowired
    public CustomerForgotPasswordSecurityTokenServiceImpl(CustomerForgotPasswordSecurityTokenDao dao) {
        super(dao);
        this.dao = dao;
    }

}

