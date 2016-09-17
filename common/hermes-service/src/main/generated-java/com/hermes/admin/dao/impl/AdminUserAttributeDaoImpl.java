package com.hermes.admin.dao.impl;

import com.hermes.admin.domain.AdminUserAttribute;
import com.hermes.admin.dao.AdminUserAttributeDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class AdminUserAttributeDaoImpl extends GenericEntityDaoImpl<Long, AdminUserAttribute> implements AdminUserAttributeDao {

}

