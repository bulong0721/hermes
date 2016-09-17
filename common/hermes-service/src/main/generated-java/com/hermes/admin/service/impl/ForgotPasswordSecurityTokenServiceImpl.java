package com.hermes.admin.service.impl;

import com.hermes.admin.domain.ForgotPasswordSecurityToken;
import com.hermes.admin.dao.ForgotPasswordSecurityTokenDao;
import com.hermes.admin.service.ForgotPasswordSecurityTokenService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class ForgotPasswordSecurityTokenServiceImpl extends GenericEntityServiceImpl<String, ForgotPasswordSecurityToken> implements ForgotPasswordSecurityTokenService {

    protected ForgotPasswordSecurityTokenDao dao;

    @Autowired
    public ForgotPasswordSecurityTokenServiceImpl(ForgotPasswordSecurityTokenDao dao) {
        super(dao);
        this.dao = dao;
    }

}

