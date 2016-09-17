package com.hermes.customer.dao.impl;

import com.hermes.customer.domain.CustomerAddress;
import com.hermes.customer.dao.CustomerAddressDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

import java.util.List;

@Repository
public class CustomerAddressDaoImpl extends GenericEntityDaoImpl<Long, CustomerAddress> implements CustomerAddressDao {

    @Override
    public List<CustomerAddress> listActiveByCustomerId(Long customerId) {
        return null;
    }

    @Override
    public void makeDefault(Long customerAddressId, Long customerId) {

    }

    @Override
    public CustomerAddress getDefault(Long customerId) {
        return null;
    }
}

