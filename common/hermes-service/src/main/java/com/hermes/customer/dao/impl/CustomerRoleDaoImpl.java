package com.hermes.customer.dao.impl;

import com.hermes.core.dao.GenericEntityDaoImpl;
import com.hermes.customer.dao.CustomerRoleDao;
import com.hermes.customer.domain.CustomerRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Martin on 2016/4/21.
 */
@Service
public class CustomerRoleDaoImpl extends GenericEntityDaoImpl<Long, CustomerRole> implements CustomerRoleDao {

    @Override
    public List<CustomerRole> listByCustomerId(Long customerId) {
        return null;
    }
}
