package com.hermes.pickup.service.impl;

import com.hermes.pickup.domain.Order;
import com.hermes.pickup.dao.OrderDao;
import com.hermes.pickup.service.OrderService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class OrderServiceImpl extends GenericEntityServiceImpl<Long, Order> implements OrderService {

    protected OrderDao dao;

    @Autowired
    public OrderServiceImpl(OrderDao dao) {
        super(dao);
        this.dao = dao;
    }

}

