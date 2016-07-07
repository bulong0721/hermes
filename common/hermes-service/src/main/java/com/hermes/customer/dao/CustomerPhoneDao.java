package com.hermes.customer.dao;

import com.hermes.core.dao.GenericEntityDao;
import com.hermes.customer.domain.CustomerPhone;

import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
public interface CustomerPhoneDao extends GenericEntityDao<Long, CustomerPhone> {

    List<CustomerPhone> listActiveByCustomerId(Long customerId);

    void makeDefault(Long customerPhoneId, Long customerId);

    CustomerPhone getDefaultPhone(Long customerId);

    List<CustomerPhone> listByCustomerId(Long customerId);
}
