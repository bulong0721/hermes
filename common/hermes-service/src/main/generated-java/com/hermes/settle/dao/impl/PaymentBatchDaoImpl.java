package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.PaymentBatch;
import com.hermes.settle.dao.PaymentBatchDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class PaymentBatchDaoImpl extends GenericEntityDaoImpl<Long, PaymentBatch> implements PaymentBatchDao {

}

