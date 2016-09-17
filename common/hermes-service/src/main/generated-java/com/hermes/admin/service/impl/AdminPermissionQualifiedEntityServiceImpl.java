package com.hermes.admin.service.impl;

import com.hermes.admin.domain.AdminPermissionQualifiedEntity;
import com.hermes.admin.dao.AdminPermissionQualifiedEntityDao;
import com.hermes.admin.service.AdminPermissionQualifiedEntityService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class AdminPermissionQualifiedEntityServiceImpl extends GenericEntityServiceImpl<Long, AdminPermissionQualifiedEntity> implements AdminPermissionQualifiedEntityService {

    protected AdminPermissionQualifiedEntityDao dao;

    @Autowired
    public AdminPermissionQualifiedEntityServiceImpl(AdminPermissionQualifiedEntityDao dao) {
        super(dao);
        this.dao = dao;
    }

}

