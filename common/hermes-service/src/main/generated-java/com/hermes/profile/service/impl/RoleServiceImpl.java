package com.hermes.profile.service.impl;

import com.hermes.profile.domain.Role;
import com.hermes.profile.dao.RoleDao;
import com.hermes.profile.service.RoleService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class RoleServiceImpl extends GenericEntityServiceImpl<Long, Role> implements RoleService {

    protected RoleDao dao;

    @Autowired
    public RoleServiceImpl(RoleDao dao) {
        super(dao);
        this.dao = dao;
    }

}

