package com.hermes.admin.service.impl;

import com.hermes.admin.domain.AdminUserAttribute;
import com.hermes.admin.dao.AdminUserAttributeDao;
import com.hermes.admin.service.AdminUserAttributeService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class AdminUserAttributeServiceImpl extends GenericEntityServiceImpl<Long, AdminUserAttribute> implements AdminUserAttributeService {

    protected AdminUserAttributeDao dao;

    @Autowired
    public AdminUserAttributeServiceImpl(AdminUserAttributeDao dao) {
        super(dao);
        this.dao = dao;
    }

}

