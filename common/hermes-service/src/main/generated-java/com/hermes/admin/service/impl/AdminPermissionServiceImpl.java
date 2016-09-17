package com.hermes.admin.service.impl;

import com.hermes.admin.domain.AdminPermission;
import com.hermes.admin.dao.AdminPermissionDao;
import com.hermes.admin.service.AdminPermissionService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class AdminPermissionServiceImpl extends GenericEntityServiceImpl<Long, AdminPermission> implements AdminPermissionService {

    protected AdminPermissionDao dao;

    @Autowired
    public AdminPermissionServiceImpl(AdminPermissionDao dao) {
        super(dao);
        this.dao = dao;
    }

}

