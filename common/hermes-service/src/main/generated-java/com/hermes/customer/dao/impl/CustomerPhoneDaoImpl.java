package com.hermes.customer.dao.impl;

import com.hermes.customer.domain.CustomerPhone;
import com.hermes.customer.dao.CustomerPhoneDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

import java.util.List;

@Repository
public class CustomerPhoneDaoImpl extends GenericEntityDaoImpl<Long, CustomerPhone> implements CustomerPhoneDao {

    @Override
    public List<CustomerPhone> listActiveByCustomerId(Long customerId) {
        return null;
    }

    @Override
    public void makeDefault(Long customerPhoneId, Long customerId) {

    }

    @Override
    public CustomerPhone getDefaultPhone(Long customerId) {
        return null;
    }

    @Override
    public List<CustomerPhone> listByCustomerId(Long customerId) {
        return null;
    }
}

