package com.hermes.customer.service.impl;

import com.hermes.core.service.GenericEntityServiceImpl;
import com.hermes.customer.dao.CustomerDao;
import com.hermes.customer.service.CustomerService;
import com.hermes.customer.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Martin on 2016/4/21.
 */
@Service
public class CustomerServiceImpl extends GenericEntityServiceImpl<Long, Customer> implements CustomerService {

    protected CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        super(customerDao);
        this.customerDao = customerDao;
    }

    @Override
    public Customer getByUsername(String username, boolean b) {
        return null;
    }
}
