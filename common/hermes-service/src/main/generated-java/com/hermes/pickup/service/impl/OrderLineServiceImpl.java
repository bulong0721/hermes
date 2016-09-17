package com.hermes.pickup.service.impl;

import com.hermes.pickup.domain.OrderLine;
import com.hermes.pickup.dao.OrderLineDao;
import com.hermes.pickup.service.OrderLineService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class OrderLineServiceImpl extends GenericEntityServiceImpl<Long, OrderLine> implements OrderLineService {

    protected OrderLineDao dao;

    @Autowired
    public OrderLineServiceImpl(OrderLineDao dao) {
        super(dao);
        this.dao = dao;
    }

}

