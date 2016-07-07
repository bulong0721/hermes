package com.hermes.admin.service.impl;

import com.hermes.admin.dao.RoleDao;
import com.hermes.admin.service.RoleService;
import com.hermes.core.service.GenericEntityServiceImpl;
import com.hermes.profile.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Martin on 2016/4/21.
 */
@Service
public class RoleServiceImpl extends GenericEntityServiceImpl<Long, Role> implements RoleService {

    protected RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }
}
