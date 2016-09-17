package com.hermes.customer.dao.impl;

import com.hermes.customer.domain.CustomerForgotPasswordSecurityToken;
import com.hermes.customer.dao.CustomerForgotPasswordSecurityTokenDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class CustomerForgotPasswordSecurityTokenDaoImpl extends GenericEntityDaoImpl<String, CustomerForgotPasswordSecurityToken> implements CustomerForgotPasswordSecurityTokenDao {

}

