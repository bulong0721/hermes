package com.hermes.customer.service;

import com.hermes.core.service.GenericEntityService;
import com.hermes.customer.domain.CustomerRole;

import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
public interface CustomerRoleService extends GenericEntityService<Long, CustomerRole> {

    List<CustomerRole> listByCustomerId(Long customerId);
}
