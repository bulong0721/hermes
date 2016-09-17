package com.hermes.admin.dao.impl;

import com.hermes.admin.domain.AdminPermission;
import com.hermes.admin.dao.AdminPermissionDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class AdminPermissionDaoImpl extends GenericEntityDaoImpl<Long, AdminPermission> implements AdminPermissionDao {

    @Override
    public AdminPermission getByName(String name) {
        return null;
    }

    @Override
    public AdminPermission getByNameAndType(String name, String type) {
        return null;
    }
}

