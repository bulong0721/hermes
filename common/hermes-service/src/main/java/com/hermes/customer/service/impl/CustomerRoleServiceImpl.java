package com.hermes.customer.service.impl;

import com.hermes.core.service.GenericEntityServiceImpl;
import com.hermes.customer.dao.CustomerRoleDao;
import com.hermes.customer.service.CustomerRoleService;
import com.hermes.customer.domain.CustomerRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Martin on 2016/4/21.
 */
@Service
public class CustomerRoleServiceImpl extends GenericEntityServiceImpl<Long, CustomerRole> implements CustomerRoleService {

    protected CustomerRoleDao customerRoleDao;

    @Autowired
    public CustomerRoleServiceImpl(CustomerRoleDao customerRoleDao) {
        super(customerRoleDao);
        this.customerRoleDao = customerRoleDao;
    }

    @Override
    public List<CustomerRole> listByCustomerId(Long customerId) {
        return null;
    }
}
