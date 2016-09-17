package com.hermes.profile.dao.impl;

import com.hermes.profile.domain.Role;
import com.hermes.profile.dao.RoleDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class RoleDaoImpl extends GenericEntityDaoImpl<Long, Role> implements RoleDao {

}

