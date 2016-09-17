package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.Payment;
import com.hermes.settle.dao.PaymentDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class PaymentDaoImpl extends GenericEntityDaoImpl<Long, Payment> implements PaymentDao {

}

