package com.hermes.pickup.dao.impl;

import com.hermes.pickup.domain.Order;
import com.hermes.pickup.dao.OrderDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class OrderDaoImpl extends GenericEntityDaoImpl<Long, Order> implements OrderDao {

}

