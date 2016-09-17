package com.hermes.customer.service;

import com.hermes.core.service.GenericEntityService;
import com.hermes.customer.domain.Customer;

/**
 * Created by Martin on 2016/4/11.
 */
public interface CustomerService extends GenericEntityService<Long, Customer> {

    Customer getByUsername(String username);
}
