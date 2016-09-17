package com.hermes.admin.dao.impl;

import com.hermes.admin.domain.ForgotPasswordSecurityToken;
import com.hermes.admin.dao.ForgotPasswordSecurityTokenDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class ForgotPasswordSecurityTokenDaoImpl extends GenericEntityDaoImpl<String, ForgotPasswordSecurityToken> implements ForgotPasswordSecurityTokenDao {

}

