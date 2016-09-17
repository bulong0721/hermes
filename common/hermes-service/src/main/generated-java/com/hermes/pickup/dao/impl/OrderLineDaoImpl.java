package com.hermes.pickup.dao.impl;

import com.hermes.pickup.domain.OrderLine;
import com.hermes.pickup.dao.OrderLineDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class OrderLineDaoImpl extends GenericEntityDaoImpl<Long, OrderLine> implements OrderLineDao {

}

