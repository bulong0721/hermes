package com.hermes.admin.dao.impl;

import com.hermes.admin.domain.AdminRole;
import com.hermes.admin.dao.AdminRoleDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class AdminRoleDaoImpl extends GenericEntityDaoImpl<Long, AdminRole> implements AdminRoleDao {

}

