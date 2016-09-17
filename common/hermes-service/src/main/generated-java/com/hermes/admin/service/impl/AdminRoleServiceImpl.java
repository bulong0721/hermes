package com.hermes.admin.service.impl;

import com.hermes.admin.domain.AdminRole;
import com.hermes.admin.dao.AdminRoleDao;
import com.hermes.admin.service.AdminRoleService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class AdminRoleServiceImpl extends GenericEntityServiceImpl<Long, AdminRole> implements AdminRoleService {

    protected AdminRoleDao dao;

    @Autowired
    public AdminRoleServiceImpl(AdminRoleDao dao) {
        super(dao);
        this.dao = dao;
    }

}

