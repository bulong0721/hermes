package com.hermes.customer.dao.impl;

import com.hermes.customer.domain.CustomerAttribute;
import com.hermes.customer.dao.CustomerAttributeDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class CustomerAttributeDaoImpl extends GenericEntityDaoImpl<Long, CustomerAttribute> implements CustomerAttributeDao {

}

