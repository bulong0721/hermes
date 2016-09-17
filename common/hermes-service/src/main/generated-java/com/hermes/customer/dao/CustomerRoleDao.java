package com.hermes.customer.dao;

import com.hermes.core.dao.GenericEntityDao;
import com.hermes.customer.domain.CustomerRole;

import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
public interface CustomerRoleDao extends GenericEntityDao<Long, CustomerRole> {

    List<CustomerRole> listByCustomerId(Long customerId);
}
